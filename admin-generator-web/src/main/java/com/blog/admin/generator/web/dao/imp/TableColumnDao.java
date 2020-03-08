package com.blog.admin.generator.web.dao.imp;

import com.blog.admin.generator.web.dao.ITableColumnDao;
import com.blog.admin.generator.web.domain.TableColumn;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class TableColumnDao implements ITableColumnDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<String> selectTables(String dataBaseName) {
         String sql="select table_name from information_schema.tables where table_schema=?";
         try {
             List<String> list= jdbcTemplate.queryForList(sql,String.class,dataBaseName);
             return list;
         }
         catch (Exception ex)
         {
             return null;
         }

    }
    @Override
    public List<TableColumn> selectColumns(String tableName)  {
        String sql="select  column_name,is_nullable,data_type,column_type,column_key,column_comment,extra " +
                "from information_schema.columns where table_name = ?";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql,tableName);
        List<TableColumn> tableColumns=new ArrayList<>();
        String[] fieldTypes={"datetime"};
        while (rowSet.next())
        {
            TableColumn tableColumn=new TableColumn();
            tableColumn.setFieldName(rowSet.getString("column_name"));
            tableColumn.setFieldType(rowSet.getString("data_type"));
            String columnType=rowSet.getString("column_type");
            if (!ArrayUtils.contains(fieldTypes,columnType)) {
                int index = columnType.indexOf('(');
                int index1 = columnType.indexOf(')');
                String length = columnType.substring(index + 1, index1);
                tableColumn.setLength(length);
            }
            String columnKey=rowSet.getString("column_key");
            if (StringUtils.isNotBlank(columnKey)&&columnKey.equals("PRI"))
                tableColumn.setPrimarkey(true);
            else
                tableColumn.setPrimarkey(false);
            tableColumn.setNull(rowSet.getString("is_nullable").equals("NO")?false:true);
            tableColumn.setContent(rowSet.getString("column_comment"));
            String extra=rowSet.getString("extra");
            if (StringUtils.isNotBlank(extra)&&extra.equals("auto_increment"))
                tableColumn.setAutoIncrement(true);
            else
                tableColumn.setAutoIncrement(false);
            tableColumns.add(tableColumn);
        }
        return  tableColumns;
    }
}
