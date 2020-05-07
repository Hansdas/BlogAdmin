package com.blog.cms.service.system.imp;

import com.blog.cms.common.ListUtils;
import com.blog.cms.common.exception.ServiceException;
import com.blog.cms.dao.system.MenuMapper;
import com.blog.cms.domain.menu.Menu;
import com.blog.cms.domain.menu.MenuDto;
import com.blog.cms.service.system.IMenuService;
import com.sun.org.apache.bcel.internal.generic.NEW;
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
    public void Save(List<Menu> menus,String parentNumber) throws ServiceException   {
        String rootNumber="";
        try {
            rootNumber=getRootMenu(parentNumber).getNumber();
        }
        catch (ServiceException e){

        }
        Map<String,Object> condition=new HashMap<>();
        condition.put("number",parentNumber);
        Menu parentMenu=menuMapper.selectSingle(condition);
        condition=new HashMap<>();
        condition.put("numberIn",menus.stream().filter(s->StringUtils.isNotEmpty(s.getNumber()))
                .map(s->s.getNumber()).collect(Collectors.toList()));
        menuMapper.delete(condition);
        int count=0;
        if (parentNumber.equals("0"))
            parentNumber="";
        for (Menu menu:menus)
        {
            count++;
            String num="";
            if (menu.getIsRootNode()) {
                num = parentNumber + StringUtils.rightPad(String.valueOf(count), 3, '0');
                menu.setRootNode(num);
            }
            else {
                num = parentNumber + StringUtils.leftPad(String.valueOf(count), 2, '0');
                menu.setRootNode(rootNumber);
                menu.setParentNodeNumber(parentNumber);
                menu.setParentNode(parentMenu.getParentNode());
            }

            menu.setNumber(num);
        };
        menuMapper.batchInsert(menus);
    }

    /**
     * 根据number查找根目录
     * @param number
     * @return
     * @throws ServiceException
     */
    private Menu getRootMenu(String number) throws ServiceException{
        Map<String,Object> condition=new HashMap<>();
        condition.put("number",number);
        List<Menu> menus=menuMapper.select(condition);
        Menu menu= ListUtils.firstOrDefault(menus);
        if (menu==null)
            throw new ServiceException("未找到编号："+number+"的菜单数据");
        if (!menu.getIsRootNode())
            getRootMenu(menu.getParentNodeNumber());
        return menu;
    }
    private List<MenuDto> findChildrenMenu(List<Menu> parents, List<Menu> menus) {
        List<MenuDto> menuDtos = new ArrayList<>();
        for (Menu item : parents) {
            MenuDto menuDto=new MenuDto();
            if (item.getIsLeafNode()) {
                 menuDto = getMenuDto(item);
                menuDtos.add(menuDto);
            } else {
                //获取当前节点下的子节点
                List<Menu> parentsMenus = menus.stream()
                        .filter(s ->s.getParentNodeNumber()!=null&& s.getParentNodeNumber().equals(item.getNumber())).collect(Collectors.toList());
                menuDto.setId(item.getNumber());
                menuDto.setTitle(item.getNodeName());
                menuDto.setChildren(findChildrenMenu(parentsMenus, parents));
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
        return menuDto;
    }

    @Override
    public List<MenuDto> selectDto() {

        List<Menu> menus = menuMapper.select(new HashMap<>());
        List<MenuDto> menuDtos = new ArrayList<>();
        List<String> rootNodeIds = menus.stream().filter(s->s.getIsRootNode()).map(Menu::getNumber).collect(Collectors.toList());
        for (String item : rootNodeIds) {
            MenuDto menuDto = new MenuDto();
            Menu menu = menus.stream().filter(s -> s.getNumber().equals(item)).findFirst().get();
            List<Menu> parents = menus.stream().filter(s ->s.getParentNodeNumber()!=null&& s.getParentNodeNumber().equals(item)).collect(Collectors.toList());
            menuDto.setId(menu.getNumber());
            menuDto.setRootNode(menu.getIsRootNode());
            menuDto.setTitle(menu.getNodeName());
            menuDto.setChildren(findChildrenMenu(parents, menus));
            menuDto.setParentNode(menu.getParentNode());
            menuDtos.add(menuDto);
        }
        return menuDtos;
    }
    public String getMenuHtml(){
        List<MenuDto> menuDtoList=selectDto();
        StringBuilder builder=new StringBuilder();
        builder.append("<li class='layui-nav-item'>");
        BuildHtml(menuDtoList, builder);
        builder.append("</li>");
        return  builder.toString();
    }
    private  void  BuildHtml(List<MenuDto>  menuDtoList,StringBuilder builder){
        for (MenuDto menuDto:menuDtoList){
            if (menuDto.getChildren()!=null&&(menuDto.getChildren().size()>0)) {
                builder.append("<a class='' href='javascript:;'>"+menuDto.getTitle()+"<span class='layui-nav-more'></span></a>");
                builder.append("<dl class='layui-nav-child'>");
                builder.append("<dd>");
                BuildHtml(menuDto.getChildren(), builder);
            }
            else
            {
                builder.append("<a href='javascript:;' style='padding-left: 60px' onclick='menuOpen('.."+menuDto.getHref()+"')'>"+menuDto.getTitle()+"</a>");
            }
        }
        builder.append("</dd>");
        builder.append("</dl>");
    }

}
