package com.blog.cms.dao.b.bm;

import com.blog.cms.domain.bm.LeaveMessage;
import java.util.List;
import java.util.Map;

public interface LeaveMessageMapper {

    int insert(LeaveMessage LeaveMessage);

    int update(LeaveMessage LeaveMessage);

    LeaveMessage selectById(int id);

    List<LeaveMessage> selectByPage(Map<String, Object> condition);

    List<LeaveMessage> Select(Map<String,Object> condition);

    int selectCount(Map<String,Object> condition);

    void Delete(int id);
}