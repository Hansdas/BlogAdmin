package com.blog.cms.dao.b.system;

import com.blog.cms.domain.system.config.Log;

import java.util.List;

public interface LogMapper {

    Log selectById(int id);

    List<Log> selectByPage(int currentPage, int pageSize);

    void Delete(int id);
}