package com.blog.cms.dao.b.bm;

import com.blog.cms.domain.bm.Article;
import java.util.List;
import java.util.Map;
public interface ArticleMapper {

    int insert(Article Article);

    int update(Article Article);

    Article selectById(int id);

    List<Article> select(Map<String,Object> condition);

    List<Article> selectByPage(Map<String,Object> condition);

    List<Article> selectColumnsPage(Map<String,Object> condition);

    int selectCount(Map<String,Object> condition);

    void DeleteById(int id);

    void DeleteById(Map<String,Object> condition);
}