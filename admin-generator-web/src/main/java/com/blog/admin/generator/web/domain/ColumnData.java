package com.blog.admin.generator.web.domain;

public class ColumnData {
    private String fieldName;
    private String jdbcType;
    private String mapColumn;
    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getJdbcType() {
        return jdbcType;
    }

    public void setJdbcType(String jdbcType) {
        this.jdbcType = jdbcType;
    }

    public String getMapColumn() {
        return mapColumn;
    }

    public void setMapColumn(String mapColumn) {
        this.mapColumn = mapColumn;
    }

}
