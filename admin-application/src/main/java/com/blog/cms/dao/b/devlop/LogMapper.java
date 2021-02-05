package com.blog.cms.dao.b.devlop;

import com.blog.cms.domain.devlop.Log;

import java.util.List;

public interface LogMapper {

    Log selectById(int id);

    List<Log> selectByPage(int currentPage, int pageSize);

    void Delete(int id);
}