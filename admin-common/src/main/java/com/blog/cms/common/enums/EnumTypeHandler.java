package com.blog.cms.common.enums;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EnumTypeHandler<T extends EnumBase> extends BaseTypeHandler<T> {
    private Class<T> type;
    private T[] enums;
    public  EnumTypeHandler(Class<T> type){
        if (type==null)
            throw new IllegalArgumentException("参数type为null");
        this.type=type;
        enums=type.getEnumConstants();
    }
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, T t, JdbcType jdbcType) throws SQLException {
        preparedStatement.setObject(i,(String)t.getValue(),jdbcType.TYPE_CODE);
    }

    @Override
    public T getNullableResult(ResultSet resultSet, String s) throws SQLException {
      int value= resultSet.getInt(s);
      if (resultSet.wasNull())
          return  null;
      else
          return  getEnum(value);
    }

    @Override
    public T getNullableResult(ResultSet resultSet, int i) throws SQLException {
        int value= resultSet.getInt(i);
        if (resultSet.wasNull())
            return  null;
        else
            return  getEnum(value);
    }

    @Override
    public T getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        int value= callableStatement.getInt(i);
        if (callableStatement.wasNull())
            return  null;
        else
            return  getEnum(value);
    }

    private T getEnum(Integer value){
        for (T t:enums){
            if (t.getValue().equals(String.valueOf(value))){
                return  t;
            }
        }
        throw new  IllegalArgumentException("未知的枚举类型："+value);
    }
}
