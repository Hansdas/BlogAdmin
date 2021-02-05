package com.blog.cms.web.controller.system;

import com.blog.cms.common.JsonResult;
import com.blog.cms.dao.b.system.UserMapper;
import com.blog.cms.domain.system.User;
import com.blog.cms.web.utils.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    UserMapper userMapper;
    @RequestMapping(value = "list/page",method = RequestMethod.POST)
    public JsonResult getPageList(HttpServletRequest request){
        String currentPage=request.getParameter("currentPage");
        String pageSize=request.getParameter("pageSize");
        Map<String,Object> condition= PageHelper.getPageMap(Integer.parseInt(currentPage),Integer.parseInt(pageSize));
        List<User> users= userMapper.selectByPage(condition);
        int count=userMapper.selectCount(condition);
        Map<String,Object> map=new HashMap<>();
        map.put("list",users);
        map.put("total",count);
        return JsonResult.Success(map);
    }
}
