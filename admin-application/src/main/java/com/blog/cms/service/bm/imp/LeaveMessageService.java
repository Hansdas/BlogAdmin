package com.blog.cms.service.bm.imp;

import com.blog.cms.dao.b.bm.LeaveMessageMapper;
import com.blog.cms.domain.bm.LeaveMessage;
import com.blog.cms.service.bm.ILeaveMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LeaveMessageService implements ILeaveMessageService {
    @Autowired
    public LeaveMessageMapper leaveMessageMapper;

    @Override
    public List<LeaveMessage> GetListPage(Map<String,Object> condition) {
      List<LeaveMessage> list=leaveMessageMapper.selectByPage(condition);
      return  list;
    }
}
