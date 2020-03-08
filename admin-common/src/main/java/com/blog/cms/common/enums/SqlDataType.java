package com.blog.cms.common.enums;

/**
 * 茶用数据库字段类型
 */
public enum SqlDataType implements EnumBase {
    INT("int","int"),
    VARCHAR("varchar","varchar"),
    DECMAIL("decmail","decmail"),
    DOUBLE("double","double"),
    FLOAT("float","float"),
    BIT("bit","bit"),
    TEXT("text","text"),
    DATETIME("datetime","datetime"),
    CHAR("char","char");
    private String text;
    private String value;
    SqlDataType(String text,String value)
    {
        this.text=text;
        this.value=value;
    }
    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String getText() {
        return text;
    }
}
