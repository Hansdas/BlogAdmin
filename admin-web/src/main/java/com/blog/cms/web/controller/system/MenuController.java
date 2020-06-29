package com.blog.cms.web.controller.system;

import com.alibaba.fastjson.JSON;
import com.blog.cms.common.JsonResult;
import com.blog.cms.common.ListUtils;
import com.blog.cms.common.exception.ServiceException;
import com.blog.cms.dao.c.system.MenuMapper;
import com.blog.cms.domain.system.menu.Menu;
import com.blog.cms.domain.system.menu.MenuDto;
import com.blog.cms.service.system.imp.MenuService;
import com.blog.cms.web.utils.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/menu")
public class MenuController {
    @Autowired
    MenuMapper menuMapper;
    @Autowired
    MenuService menuService;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public  Map<String,Object> getListByPage(@RequestParam int currentPage, @RequestParam int pageSize, @RequestParam(required = false) String nodeName) {
        Map<String, Object> condition = PageHelper.getPageMap(currentPage, pageSize);
        if (StringUtils.isNotEmpty(nodeName))
            condition.put("nodeNameContain", nodeName);
        List<Menu> menus = menuMapper.selectByPage(condition);
        int count=menuMapper.selectCount(condition);
        Map<String,Object> map=new HashMap<>();
        map.put("menus",menus);
        map.put("total",count);
        return map;
    }

    @RequestMapping(value = "/getList", method = RequestMethod.POST)
    public JsonResult getList(HttpServletRequest request) {
        Map<String, Object> condition = new HashMap<>();
        String parentNumber = request.getParameter("parentNumber");
        String isRootNode = request.getParameter("isRootNode");
        if (StringUtils.isNotEmpty(parentNumber))
            condition.put("parentNumber", parentNumber);
        if (StringUtils.isNotEmpty(isRootNode))
            condition.put("isRootNode", Boolean.parseBoolean(isRootNode));
        List<Menu> menus = menuMapper.select(condition);
        if (menus.size() == 0) {
            Menu menu = new Menu();
            menu.setIsRootNode(true);
            menus.add(menu);
        }
        return new JsonResult("0", menus);
    }

    @RequestMapping(value = "/list/getRootlist", method = RequestMethod.GET)
    public JsonResult getRootList(@PathVariable String parentNumber) {
        Map<String, Object> condition = new HashMap<>();
        condition.put("isRootNode", true);
        List<Menu> menus = menuMapper.select(condition);
        if (menus.size() == 0) {
            Menu menu = new Menu();
            menu.setIsRootNode(true);
            menus.add(menu);
        }
        return new JsonResult("0", menus);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public JsonResult addMenu(HttpServletRequest request) throws ServiceException {
        //menuService.Save(menu);
        String json = request.getParameter("menus");
        String parentNumber = request.getParameter("parentNumber");
        String json2=request.getParameter("deleteNumbers");
        List<Menu> menus= JSON.parseArray(json,Menu.class) ;
        List<String> deleteNumbers=JSON.parseArray(json2,String.class);
        menuService.Save(menus,parentNumber,deleteNumbers);
        return new JsonResult("0", "保存成功");
    }

    @RequestMapping(value = "/dto/list", method = RequestMethod.POST)
    public JsonResult addMenu() {
        List<MenuDto> menuDtos = menuService.selectDto();
        return new JsonResult("0", menuDtos);
    }

    @RequestMapping(value = "/count", method = RequestMethod.POST)
    public JsonResult getTotalCount(@RequestParam(required = false) String nodeName) {
        Map<String, Object> condition = new HashMap<>();
        if (StringUtils.isNotEmpty(nodeName))
            condition.put("nodeNameContain", nodeName);
        int count = menuMapper.selectCount(condition);
        return new JsonResult("0", count);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public JsonResult deleteById(@PathVariable int id) {
        menuMapper.deleteById(id);
        return new JsonResult("0", null);
    }
    @RequestMapping(value = "/html",method = RequestMethod.GET)
    public String getMenuHtml(){
        String html=menuService.getMenuHtml();
        return html;
    }
}
