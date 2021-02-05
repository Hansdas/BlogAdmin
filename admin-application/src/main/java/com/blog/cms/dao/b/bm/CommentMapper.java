package com.blog.cms.dao.b.bm;

import com.blog.cms.domain.bm.Comment;
import java.util.List;
import java.util.Map;
public interface CommentMapper {

    int insert(Comment Comment);

    int update(Comment Comment);

    Comment selectById(int id);

    List<Comment> select(Map<String,Object> condition);

    List<Comment> selectByPage(int currentPage,int pageSize);

    int selectCount(Map<String,Object> condition);

    void DeleteById(int id);

    void DeleteById(Map<String,Object> condition);
}