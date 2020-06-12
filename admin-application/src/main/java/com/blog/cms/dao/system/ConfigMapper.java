package com.blog.cms.dao.system;

import com.blog.cms.domain.system.config.Config;

import java.util.List;
import java.util.Map;

public interface ConfigMapper {

    int insert(Config Config);

    int update(Config Config);

    int selectCount(Map<String, Object> condition);

    Config selectById(int id);

    List<Config> selectByPage(int currentPage, int pageSize);

    void Delete(int id);
}