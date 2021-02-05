package com.blog.cms.domain.enums;

import com.blog.cms.common.enums.EnumBase;

public enum Sex implements EnumBase {
    MAN("男","1"),
    WOMEN女("","2");
    private Sex(String text,String value){
        this.text=text;
        this.value=value;
    }
    private String text;
    private String value;
    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String getText() {
        return text;
    }
}
