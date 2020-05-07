package com.blog.cms.generator.web.utils;

import com.blog.cms.generator.web.domain.TableColumn;
import freemarker.template.Configuration;
import freemarker.template.ObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class CreateMapper {

    private static Configuration configuration=new Configuration();
    static {
        try {
            configuration.setDirectoryForTemplateLoading(new File(System.getProperty("user.dir")
                    +"\\admin-generator-web\\src\\main\\resources\\static\\templates"));
            configuration.getTemplate("xmlTemp.ftl");
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }
    public  static void creatXml(String tableName,String xmlPath,String daoPackage,String domainPakcage,List<TableColumn> tableColumns)
    {
        String className=tableName.split("_")[1];
        Map<String,Object> map=new HashMap<>();
        map.put("className",className);
        map.put("daoPackage",daoPackage);
        map.put("domainPackage",domainPakcage);
        String fields=  StringUtils.join(tableColumns.stream().map(TableColumn::getFieldName).collect(Collectors.toList()),",");
        map.put("baseColumnList",fields);
        createColumn(map,tableColumns,tableName);
        createInsert(map,tableColumns,tableName);
        createUpdate(map,tableColumns,tableName);
        createSelectById(map,tableColumns,tableName);
        createSelectByPage(map,tableColumns,tableName);
        createDeleteById(map,tableColumns,tableName);
        File file=new File(xmlPath);
        if (!file.exists())
            file.mkdirs();
        File outFile = new File(xmlPath+"\\"+className+"Mapper.xml");
        Writer out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile)));
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        try {
            Template t = configuration.getTemplate("xmlTemp.ftl"); //文件名
            t.process(map, out, ObjectWrapper.BEANS_WRAPPER);
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void  createColumn( Map<String,Object> map,List<TableColumn> tableColumns,String tableName){
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<tableColumns.size();i++){
            TableColumn tableColumn=tableColumns.get(i);
            if (i==0) {
                sb.append(String.format(" <id column='%s'  property='%s'/>\r\n",tableColumn.getFieldName(),tableColumn.getPropertyName()));
            }
            else
                sb.append(String.format(" \t\t<result  column='%s'  property='%s'/>\r\n",tableColumn.getFieldName(),tableColumn.getPropertyName()));

        }
        map.put("column",sb.toString());

    }

    private static void  createInsert( Map<String,Object> map,List<TableColumn> tableColumns,String tableName){
        StringBuilder sb=new StringBuilder().append("insert into "+tableName +"(\r\n ");
        String fields=  StringUtils.join(tableColumns.stream().map(TableColumn::getFieldName).collect(Collectors.toList()),",\r\n\t\t");
        sb.append(fields+" )\r\n\t\tvalues\r\n \t\t(\r\n ");
        for (int i=0;i<tableColumns.size();i++){
            TableColumn tableColumn=tableColumns.get(i);
            sb.append(String.format("\t\t#{%s,jdbcType=%s}",tableColumn.getPropertyName(),convertJdbcType(tableColumn.getFieldType())));
            if (i<tableColumns.size()-1) {
                sb.append(",\r\n");
            }
            else
                sb.append(" )");
        }
        map.put("insert",sb.toString());

    }

    private static void  createUpdate( Map<String,Object> map,List<TableColumn> tableColumns,String tableName){
        StringBuilder sb=new StringBuilder().append("update  "+tableName +"set\r\n ");
        for (int i=0;i<tableColumns.size();i++){
            TableColumn tableColumn=tableColumns.get(i);
            sb.append("\t\t\t"+tableColumn.getFieldName());
            sb.append( " = ");
            sb.append(String.format("#{%s,jdbcType=%s}",tableColumn.getPropertyName(),convertJdbcType(tableColumn.getFieldType())));
            if (i<tableColumns.size()-1) {
                sb.append(",\r\n");
            }
        }
        sb.append(" \r\n\t\t\twhere ");
        sb.append(tableColumns.get(0).getFieldName());
        sb.append(" = ");
        sb.append("#{id,jdbcType=INTEGER}");
        map.put("update",sb.toString());
    }
    private static void  createSelectById( Map<String,Object> map,List<TableColumn> tableColumns,String tableName){
        TableColumn tableColumn=tableColumns.get(0);
        StringBuilder sb=new StringBuilder().append(" select <include refid='Base_Column_List'/> from ");
        sb.append(tableName);
        sb.append(" where ");
        sb.append(tableColumn.getFieldName());
        sb.append(" = ");
        sb.append(String.format("#{%s,jdbcType=INTEGER}",tableColumn.getPropertyName()));
        map.put("selectById",sb.toString());
    }
    private static void  createSelectByPage( Map<String,Object> map,List<TableColumn> tableColumns,String tableName){
        TableColumn tableColumn=tableColumns.get(0);
        StringBuilder sb=new StringBuilder().append(" select <include refid='Base_Column_List'/> from ");
        sb.append(tableName);
        sb.append(" limit #{currentPage},#{pageSize}");
        map.put("selectByPage",sb.toString());
    }
    private static void  createDeleteById( Map<String,Object> map,List<TableColumn> tableColumns,String tableName){
        TableColumn tableColumn=tableColumns.get(0);
        StringBuilder sb=new StringBuilder().append(" delete * from ");
        sb.append(tableName);
        sb.append(" where ");
        sb.append(tableColumn.getFieldName());
        sb.append(" = ");
        sb.append(String.format("#{%s,jdbcType=INTEGER}",tableColumn.getPropertyName()));
        map.put("deleteById",sb.toString());
    }
    private static String convertJdbcType(String type){
        switch (type){
            case "String":
                return "VARCHAR";
            case  "int":
                return "INTEGER";
            case  "boolean":
                return "BIT";
            case  "Date":
                return "DATE";
        }
        return "VARCHAR";
    }
}
