package com.blog.cms.service.system.imp;

import com.blog.cms.common.ListUtils;
import com.blog.cms.common.exception.ServiceException;
import com.blog.cms.dao.system.MenuMapper;
import com.blog.cms.domain.system.menu.Menu;
import com.blog.cms.domain.system.menu.MenuDto;
import com.blog.cms.service.system.IMenuService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class MenuService implements IMenuService {
    @Autowired
    MenuMapper menuMapper;

    @Override
    @Transactional
    public void Save(List<Menu> menus, String parentNumber, List<String> deleteNumbers) throws ServiceException {
        String rootNumber = "";
        try {
            rootNumber = getRootMenu(parentNumber).getNumber();
        } catch (ServiceException e) {

        }
        Map<String, Object> condition = new HashMap<>();
        condition.put("number", parentNumber);
        Menu parentMenu = menuMapper.selectSingle(condition);//查出父节点
        condition = new HashMap<>();//删除本次传入的节点后续再从新插入
        condition.put("numberIn",menus.stream().filter(s->StringUtils.isNotEmpty(s.getNumber())).map(s->s.getNumber()).collect(Collectors.toList()));
        menuMapper.delete(condition);
        if (deleteNumbers.size()>0){//有删除操作
            List<Menu> deleteMenus=new ArrayList<>();
            findAllChildMenus(deleteNumbers,deleteMenus);
            deleteNumbers.addAll(deleteMenus.stream().map(s->s.getNumber()).collect(Collectors.toList()));
            condition = new HashMap<>();
            condition.put("numberIn",deleteNumbers);
            menuMapper.delete(condition);
        }
        Menu maxMenu=menus.stream().filter(s->StringUtils.isNotEmpty(s.getNumber())).findFirst().orElse(null);
        int maxNumber=0;
        if (menus.size()>0){
            for (Menu menu : menus) {
                String num = "";
                if (menu.getIsRootNode()) {
                    if (StringUtils.isEmpty(menu.getNumber())){
                        if (maxMenu!=null) {
                            maxNumber = Integer.parseInt(maxMenu.getNumber()) + 100;
                            num =String.valueOf(maxNumber);
                        }
                        menu.setNumber(num);
                    }
                    menu.setRootNode(menu.getNumber());
                } else {
                    if (StringUtils.isEmpty(menu.getNumber())){
                        if (maxMenu!=null)
                            maxNumber=Integer.parseInt(maxMenu.getNumber())+1;
                        else
                            maxNumber=Integer.parseInt(parentNumber+"01");
                        num =String.valueOf(maxNumber);
                        menu.setNumber(num);
                    }
                    menu.setRootNode(rootNumber);
                    menu.setParentNodeNumber(parentNumber);
                    if (parentMenu!=null)
                        menu.setParentNode(parentMenu.getParentNode());
                    if (StringUtils.isNotEmpty(menu.getNodePath()))
                        menu.setIsLeafNode(true);
                }
            }
            menuMapper.batchInsert(menus);
        }
    }

    /**
     * 根据number查找根目录
     *
     * @param number
     * @return
     * @throws ServiceException
     */
    private Menu getRootMenu(String number) throws ServiceException {
        Map<String, Object> condition = new HashMap<>();
        condition.put("number", number);
        List<Menu> menus = menuMapper.select(condition);
        Menu menu = ListUtils.firstOrDefault(menus);
        if (menu == null)
            throw new ServiceException("未找到编号：" + number + "的菜单数据");
        if (!menu.getIsRootNode())
            getRootMenu(menu.getParentNodeNumber());
        return menu;
    }
    /**
     * 根据父菜单编码获取子菜单
     * @return
     */
    private List<Menu> findAllChildMenus(List<String> parentNumbers,List<Menu> menus) {
        Map<String,Object> condition=new HashMap<>();
        condition.put("parentNumberIn",parentNumbers);
        List<Menu> childMenus=menuMapper.select(condition);
        if (childMenus.size()>0){
            menus.addAll(childMenus);
            childMenus= findAllChildMenus(childMenus.stream().map(s->s.getNumber()).collect(Collectors.toList()),menus);
        }
        return menus;
    }
    /**
     * 遍历获取子目录
     *
     * @param parents
     * @param menus
     * @return
     */
    private List<MenuDto> findChildrenMenuDto(List<Menu> parents, List<Menu> menus) {
        List<MenuDto> menuDtos = new ArrayList<>();
        for (Menu item : parents) {
            MenuDto menuDto = new MenuDto();
            if (item.getIsLeafNode()) {
                menuDto = getMenuDto(item);
                menuDtos.add(menuDto);
            } else {
                //获取当前节点下的子节点集合
                List<Menu> childMenus = menus.stream()
                        .filter(s -> s.getParentNodeNumber() != null && s.getParentNodeNumber().equals(item.getNumber())).collect(Collectors.toList());
                menuDto.setId(item.getNumber());
                menuDto.setTitle(item.getNodeName());
                menuDto.setChildren(findChildrenMenuDto(childMenus, parents));
                menuDtos.add(menuDto);
            }
        }
        return menuDtos;
    }

    private MenuDto getMenuDto(Menu menu) {
        MenuDto menuDto = new MenuDto();
        menuDto.setId(menu.getNumber());
        menuDto.setTitle(menu.getNodeName());
        menuDto.setHref(menu.getNodePath());
        menuDto.setRootNode(menu.getIsRootNode());
        menuDto.setParentNode(menu.getParentNode());
        menuDto.setLeafNode(menu.getIsLeafNode());
        return menuDto;
    }

    @Override
    public List<MenuDto> selectDto() {
        List<Menu> menus = menuMapper.select(new HashMap<>());
        if (menus.size()==0)
            InitMenu();
        menus = menuMapper.select(new HashMap<>());
        List<MenuDto> menuDtos = new ArrayList<>();
        //获取所有根目录
        List<String> rootNodeIds = menus.stream().filter(s -> s.getIsRootNode()).map(Menu::getNumber).collect(Collectors.toList());
        for (String item : rootNodeIds) {
            MenuDto menuDto = new MenuDto();
            Menu menu = menus.stream().filter(s -> s.getNumber().equals(item)).findFirst().get();
            //获取根目录下的子目录
            List<Menu> childMenus = menus.stream().filter(s -> s.getParentNodeNumber() != null && s.getParentNodeNumber().equals(item)).collect(Collectors.toList());
            menuDto.setId(menu.getNumber());
            menuDto.setRootNode(menu.getIsRootNode());
            menuDto.setTitle(menu.getNodeName());
            menuDto.setChildren(findChildrenMenuDto(childMenus, menus));
            menuDto.setParentNode(menu.getParentNode());
            menuDtos.add(menuDto);
        }
        return menuDtos;
    }

    /**
     * 当没有菜单时初始化默认菜单
     */
    private void InitMenu(){
        List<Menu> menus=new ArrayList<>();
        Menu menu=new Menu();//"系统设置"目录
        menu.setIsRootNode(true);
        menu.setNumber("100");
        menu.setOrder(1);
        menu.setRootNode("100");
        menu.setIsLeafNode(false);
        menu.setNodeName("系统设置");
        menus.add(menu);
        menu=new Menu();//"菜单管理目录"目录
        menu.setIsRootNode(false);
        menu.setNumber("10001");
        menu.setRootNode("100");
        menu.setOrder(1);
        menu.setParentNode("系统设置");
        menu.setParentNodeNumber("100");
        menu.setIsLeafNode(false);
        menu.setNodeName("菜单管理");
        menus.add(menu);
        menu=new Menu();//"菜单管理-添加"目录
        menu.setIsRootNode(false);
        menu.setNumber("1000101");
        menu.setRootNode("100");
        menu.setOrder(1);
        menu.setParentNode("菜单管理");
        menu.setParentNodeNumber("10001");
        menu.setIsLeafNode(true);
        menu.setNodePath("/pages/system/menu/add.html");
        menu.setNodeName("添加");
        menus.add(menu);
        menu=new Menu();//"菜单管理-添加"目录
        menu.setIsRootNode(false);
        menu.setNumber("1000102");
        menu.setRootNode("100");
        menu.setOrder(2);
        menu.setParentNode("菜单管理");
        menu.setParentNodeNumber("10001");
        menu.setIsLeafNode(true);
        menu.setNodePath("/pages/system/menu/list.html");
        menu.setNodeName("列表");
        menus.add(menu);
        menuMapper.batchInsert(menus);

    }
    public String getMenuHtml() {
        List<MenuDto> menuDtoList = selectDto();
        List<MenuDto> rootNodes=menuDtoList.stream().filter(s->s.isRootNode()).collect(Collectors.toList());
        StringBuilder builder = new StringBuilder();
        BuildHtml(menuDtoList,rootNodes, builder);
        return builder.toString();
    }

    private void BuildHtml(List<MenuDto> menuDtoList,List<MenuDto> rootNodes, StringBuilder builder) {
        for (MenuDto menuDto:rootNodes){
            builder.append("<li class='layui-nav-item'>");
            builder.append("<a class='' href='javascript:;'>" + menuDto.getTitle() + "<span class='layui-nav-more'></span></a>");
            builder.append("<dl class='layui-nav-child'>");
            BuildChildHtml(menuDto.getChildren(), builder);
            builder.append("</dl>");
            builder.append("</li>");
        }
    }
    private void BuildChildHtml(List<MenuDto> menuDtoList, StringBuilder builder) {
        for (MenuDto menuDto : menuDtoList) {
            int paddingLeft=30;
            if (menuDto.getChildren() != null) {
                builder.append("<dd>");
                builder.append("<a  style='padding-left:"+paddingLeft+"px' href='javascript:;'>" + menuDto.getTitle() + "<span class='layui-nav-more'></span></a>");
                builder.append("<dl class='layui-nav-child'>");
                builder.append("<dd>");
                BuildChildHtml(menuDto.getChildren(), builder);
                builder.append("</dd>");
                builder.append("</dl>");
                builder.append("</dd>");
            } else if (menuDto.isLeafNode()){
                paddingLeft+=30;
                builder.append("<dd>");
                builder.append(String.format("<a href=\"javascript:;\" style=\"padding-left: %spx\" onclick=\"menuOpen('..%s')\">%s</a>",paddingLeft,menuDto.getHref(),menuDto.getTitle()));

            }
            paddingLeft+=30;
        }
    }

}
