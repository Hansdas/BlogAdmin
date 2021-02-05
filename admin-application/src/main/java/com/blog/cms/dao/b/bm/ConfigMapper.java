package com.blog.cms.dao.b.bm;

import com.blog.cms.domain.system.Config;

import java.util.List;
import java.util.Map;

public interface ConfigMapper {

    int insert(Config Config);

    int update(Config Config);

    int selectCount(Map<String, Object> condition);

    Config selectById(int id);

    String selectByKey(String key);

    List<Config> selectByPage(int currentPage, int pageSize);

    void Delete(int id);
}