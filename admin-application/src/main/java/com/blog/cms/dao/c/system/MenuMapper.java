package com.blog.cms.dao.c.system;

import com.blog.cms.domain.system.menu.Menu;

import java.util.List;
import java.util.Map;

public interface MenuMapper {

    int insert(Menu Menu);

    void update(Menu Menu);

    int selectCount(Map<String, Object> condition);

    Menu selectById(int id);

    Menu selectSingle(Map<String, Object> condition);

    List<Menu> select(Map<String, Object> condition);

    List<Menu> selectByPage(Map<String, Object> condition);

    void deleteById(int id);

    void delete(Map<String, Object> condition);

    void batchInsert(List<Menu> menus);
}