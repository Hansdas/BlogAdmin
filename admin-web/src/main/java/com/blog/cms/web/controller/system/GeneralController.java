package com.blog.cms.web.controller.system;
import com.alibaba.fastjson.JSON;
import com.blog.cms.common.JsonResult;
import com.blog.cms.common.enums.EnumUtils;
import com.blog.cms.common.enums.SqlDataType;
import com.blog.cms.common.exception.ServiceException;
import com.blog.cms.dao.system.generator.ITableColumnDao;
import com.blog.cms.domain.system.generator.TableColumn;
import com.blog.cms.web.utils.generator.CreateBean;
import com.blog.cms.web.utils.generator.CreateMapper;
import com.blog.cms.web.utils.generator.createMapperClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class GeneralController {
    @Autowired
    private ITableColumnDao tableColumnDao;
    @RequestMapping(value = "/api/generator/tableNames/{dataBaseName}",method = RequestMethod.POST)
    public JsonResult getTableName(@PathVariable String dataBaseName) throws ServiceException
    {
        List<String> list= tableColumnDao.selectTables(dataBaseName);
        return new JsonResult("0",list);
    }
    @RequestMapping(value = "/api/generator/columns/{tableName}",method = RequestMethod.POST)
    public Map<String,Object> getColumn(@PathVariable String tableName) throws ServiceException
    {
        List<TableColumn> list= tableColumnDao.selectColumns(tableName);
        Map<String,Object> map= new HashMap<>();
        map.put("enum",EnumUtils.getEnumMap(SqlDataType.class));
        map.put("dataList",list);
        return map;
    }
    @RequestMapping(value = "/api/generator/create",method = RequestMethod.POST)
    public JsonResult create(HttpServletRequest request)
    {
        String tableColumnJson = request.getParameter("tableColumns");
        String domainPackageName = request.getParameter("domainPackageName");
        String tableName = request.getParameter("tableName");
        String daoPackageName = request.getParameter("daoPackageName");
        List<TableColumn> list = JSON.parseArray(tableColumnJson, TableColumn.class);
        try {
            String path=  new File(System.getProperty("user.dir")).getCanonicalPath();
            String domainPath=path+"/admin-application/src/main/java";
            String daoPath=path+"/admin-application/src/main/java";
            int index= daoPackageName.lastIndexOf('.')+1;
            String prefixXml= daoPackageName.substring(index);
            String mapperPath=path+"/admin-application/src/main/resources/mapper/"+prefixXml;
            CreateBean.create(tableName, domainPackageName, domainPath, list);
            CreateMapper.creatXml(tableName, mapperPath, daoPackageName, domainPackageName, list);
            createMapperClass.creatInterface(tableName, daoPath, daoPackageName, domainPackageName);
            return new JsonResult("0", null);
        }
        catch (IOException e){
            return new JsonResult("0", e.getMessage());
        }

    }
}
