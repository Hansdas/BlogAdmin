package com.blog.cms.dao.system;

import com.blog.cms.domain.system.config.Config;
import java.util.List;

public interface ConfigMapper {

int insert(Config Config);

int update(Config Config);

Config selectById(int id);

List<Config> selectByPage(int currentPage,int pageSize);

void Delete(int id);
}