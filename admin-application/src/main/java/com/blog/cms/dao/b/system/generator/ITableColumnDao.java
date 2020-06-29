package com.blog.cms.dao.b.system.generator;

import com.blog.cms.common.exception.ServiceException;
import com.blog.cms.domain.system.generator.TableColumn;

import java.util.List;

public interface ITableColumnDao {
    /**
     * 查询数据库表
     * @return
     */
 List<String> selectTables(String dataBaseName) throws ServiceException;

    /**
     * 查询表结构
     * @param tableName
     * @return
     */
  List<TableColumn> selectColumns(String tableName) throws ServiceException
  ;
}
