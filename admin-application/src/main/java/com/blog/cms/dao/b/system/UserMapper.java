package com.blog.cms.dao.b.system;

import com.blog.cms.domain.system.User;
import java.util.List;
import java.util.Map;
public interface UserMapper {

    int insert(User User);

    int update(User User);

    User selectById(int id);

    List<User> select(Map<String,Object> condition);

    List<User> selectByPage(Map<String,Object> condition);

    int selectCount(Map<String,Object> condition);

    void DeleteById(int id);

    void DeleteById(Map<String,Object> condition);
}