package com.blog.cms.common;

import java.util.ArrayList;
import java.util.List;

public class ListUtils  {
    /**
     * 获取l集合第一个对象
     * @param list
     * @param <T>
     * @return
     */
    public static   <T> T  firstOrDefault(List<T> list){
        if (list.size()>0)
            return list.get(0);
        return null;
    }

}
