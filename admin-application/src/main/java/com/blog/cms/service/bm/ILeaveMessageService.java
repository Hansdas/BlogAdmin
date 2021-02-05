package com.blog.cms.service.bm;

import com.blog.cms.domain.bm.LeaveMessage;

import java.util.List;
import java.util.Map;

public interface ILeaveMessageService {

    public List<LeaveMessage> GetListPage(Map<String,Object> condition);
}
