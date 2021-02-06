package com.blog.cms.service.system.imp;

import com.blog.cms.dao.b.system.UserMapper;
import com.blog.cms.service.system.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements ILoginService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public boolean login(String account, String password) {
        //userMapper.select();
        return false;
    }
}
