package com.blog.cms.web.controller.bm;

import com.blog.cms.common.JsonResult;
import com.blog.cms.dao.b.bm.LeaveMessageMapper;
import com.blog.cms.domain.bm.LeaveMessage;
import com.blog.cms.service.bm.ILeaveMessageService;
import com.blog.cms.web.utils.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class LeaveMessageController {
    @Autowired
    public ILeaveMessageService leaveMessageService;
    @Autowired
    public LeaveMessageMapper leaveMessageMapper;
    @RequestMapping(value = "/leavemessage/list",method = RequestMethod.POST)
    public Map<String,Object> getlist(@RequestParam int currentPage,@RequestParam int pageSize){
       Map<String,Object> condition= PageHelper.getPageMap(currentPage,pageSize);
       List<LeaveMessage> list=leaveMessageService.GetListPage(condition);
        int count=leaveMessageMapper.selectCount(new HashMap<>());
        Map<String,Object> result=new HashMap<>();
        result.put("data",list);
        result.put("total",count);
        return result;
    }
    public JsonResult getTotal(){
        int count=leaveMessageMapper.selectCount(new HashMap<>());
        return  new JsonResult("0",count);
    }
}
