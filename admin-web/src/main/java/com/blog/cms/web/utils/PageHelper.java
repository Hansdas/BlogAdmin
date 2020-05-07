package com.blog.cms.web.utils;

import java.util.HashMap;
import java.util.Map;

public class PageHelper {
    /**
     * 获取分页查询条件
     * @param currentPage 页数
     * @param pageSize 页大小
     * @return
     */
    public static Map<String,Object> getPageMap(int currentPage,int pageSize)
    {
        Map<String,Object> map=new HashMap<>();
        map.put("currentPage",(currentPage-1)*pageSize);
        map.put("pageSize",pageSize);
        return map;
    }
}
