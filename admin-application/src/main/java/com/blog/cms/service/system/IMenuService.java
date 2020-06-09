package com.blog.cms.service.system;

import com.blog.cms.common.exception.ServiceException;
import com.blog.cms.domain.system.menu.Menu;
import com.blog.cms.domain.system.menu.MenuDto;

import java.util.List;

public interface IMenuService {
    /**
     * 保存
     * @param
     * @return
     */
    void Save(List<Menu> menus, String parentNumber, List<String> deleteNumbers) throws ServiceException;

    /**
     * 查询dto
     * @return
     */
    List<MenuDto> selectDto();

    /**
     * 拼接菜单目录
     * @return
     */
    String getMenuHtml();
}
