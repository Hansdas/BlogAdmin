package com.blog.cms.generator.web.utils;

import com.blog.cms.generator.web.domain.TableColumn;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.String;
import java.util.List;
import java.util.stream.Collectors;

public class CreateBean {
    public static void create(String tableName, String packageName, String basePath, List<TableColumn> tableColumns) {
        String className = tableName.split("_")[1];
        StringBuilder stringBuilder = new StringBuilder();
        List<String> fieldTypes = tableColumns.stream().map(TableColumn::getFieldType).distinct().collect(Collectors.toList());
        if (fieldTypes.contains("datetime")) {
            stringBuilder.append("import java.util.Date;\r\n");
        }
        if (fieldTypes.contains("decmail")) {
            stringBuilder.append("import java.math.BigDecimal;\r\n");
        }
        stringBuilder.append("public class " + className + "{\r\n");
        for (TableColumn item : tableColumns) {
            stringBuilder.append("\t/**\r\n");
            stringBuilder.append("\t*" + item.getContent() + "\r\n");
            stringBuilder.append("\t*/\r\n");
            String property = String.format("\tprivate %s %s;\r\n", convertType(item.getFieldType()), item.getPropertyName());
            stringBuilder.append(property);

        }
        makeMethod(stringBuilder, tableColumns);
        stringBuilder.append("}");
        makeBean(stringBuilder, className, packageName, basePath);
        //stringBuilder.append(packageName);
    }

    private static String convertType(String fieldType) {
        if (fieldType.equals("int"))
            return "int";
        else if (fieldType.equals("varchar"))
            return "String";
        else if (fieldType.equals("decmail"))
            return "BigDecimal";
        else if (fieldType.equals("double"))
            return "double";
        else if (fieldType.equals("float"))
            return "float";
        else if (fieldType.equals("bit"))
            return "boolean";
        else if (fieldType.equals("text"))
            return "String";
        else if (fieldType.equals("datetime"))
            return "Date";
        else if (fieldType.equals("char"))
            return "int";
        else
            return "String";

    }

    private static StringBuilder makeMethod(StringBuilder sb, List<TableColumn> tableColumns) {
        for (TableColumn item : tableColumns) {
            String str = item.getPropertyName().substring(0, 1).toUpperCase() + item.getPropertyName().substring(1);
            String getMethod = String.format("\tpublic %s get%s(){\r\n" +
                    "return %s;\r\n" +
                    "}\r\n", convertType(item.getFieldType()), str, item.getPropertyName());
            sb.append(getMethod);
            sb.append("\r\n");
            String setMethod = String.format("\tpublic void set%s(%s %s) {\r\n" +
                            " \tthis.%s = %s;\r\n" +
                            " }\r\n", str, convertType(item.getFieldType()), item.getPropertyName(), item.getPropertyName()
                    , item.getPropertyName());
            sb.append(setMethod);
            sb.append("\r\n");
        }
        return sb;
    }

    private static void makeBean(StringBuilder content, String className, String packageName, String baseSrc) {
        String folder = baseSrc + "/" + packageName.replace('.', '/');
        File file = new File(folder);
        if (!file.exists())
            file.mkdirs();
        String fileName = folder + "/" + className + ".java";
        try {
            File newFile = new File(fileName);
            FileWriter fileWriter = new FileWriter(newFile);
            fileWriter.write("package\t" + packageName + ";\r\n");
            fileWriter.write(content.toString());
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            String s = "1";
        }
    }
}
