package com.blog.cms.domain.system.generator;

public class TableColumn {
    /**
     * 是否选中
     */
    private  boolean isSelected;
    private String propertyName;
    /**
     * 字段名
     */
    private String fieldName;
    /**
     * 字段类型
     */
    private String fieldType;
    /**
     * 字段长度
     */
    private String length;
    /**
     * 是否主键
     */
    private  boolean isPrimarkey;
    /**
     * 备注
     */
    private  String content;
    /**
     * 是否自增
     */
    private Boolean isAutoIncrement;
    /**
     * 是否可空
     */
    private  boolean isNull;
    public boolean isSelected() {
        return isSelected;
    }

    public void setSelectd(boolean selected) {
        isSelected = selected;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public boolean isPrimarkey() {
        return isPrimarkey;
    }

    public void setPrimarkey(boolean primarkey) {
        isPrimarkey = primarkey;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isNull() {
        return isNull;
    }

    public void setNull(boolean aNull) {
        isNull = aNull;
    }
    public Boolean getAutoIncrement() {
        return isAutoIncrement;
    }

    public void setAutoIncrement(Boolean autoIncrement) {
        isAutoIncrement = autoIncrement;
    }

}
