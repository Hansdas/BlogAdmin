package com.blog.cms.web.utils.generator;

import freemarker.template.Configuration;
import freemarker.template.ObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class createMapperClass {
    private static Configuration configuration=new Configuration();
    static {
        try {
            configuration.setDirectoryForTemplateLoading(new File(System.getProperty("user.dir")
                    +"\\admin-web\\src\\main\\resources\\static\\templates"));
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }
    public  static void creatInterface(String tableName, String daoPath, String daoPackage, String domainPakcage)
    {
        String className=tableName.split("_")[1];
        Map<String,Object> map=new HashMap<>();
        map.put("daoPackage",daoPackage);
        map.put("domainPackage",domainPakcage);
        map.put("className",className);
        String para=className.substring(0,1).toUpperCase()+className.substring(1);
        map.put("domainName",className);
        map.put("domainNamePara",para);
        String folder=daoPath+"\\"+daoPackage.replace(".","\\");
        File file=new File(folder);
        if (!file.exists())
            file.mkdirs();
        File outFile = new File(folder+"\\"+className+"Mapper.java");
        Writer out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile)));
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        try {
            Template t = configuration.getTemplate("daoTemp.ftl"); //文件名
            t.process(map, out, ObjectWrapper.BEANS_WRAPPER);
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
