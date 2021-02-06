package com.blog.cms.common.enums;

import java.util.HashMap;
import java.util.Map;

public  class EnumUtils {
    public static <T extends EnumBase> Map<String,String> getEnumMap(Class<T> enumClass)
    {
        Map<String,String> map=new HashMap<String, String>();
        T[] array= enumClass.getEnumConstants();
        for (T t:array)
        {
            map.put(t.getText(),t.getValue());
        }
        return map;
    }
}
