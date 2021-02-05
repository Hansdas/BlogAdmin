package com.blog.cms.domain.enums;

import com.blog.cms.common.enums.EnumBase;

public enum ArticleType implements EnumBase {
    PROSE("散文礼记","1"),
    RECALL("韶华追忆","2"),
    INTERSET("趣味百态","3"),
    PROGRAMME("编程世界","4"),
    RECREATION("编程世界","5");
    private ArticleType(String text,String value){
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
