package com.blog.cms.service.system;

public interface ILoginService {
    /**
     * 登录
     * @param account
     * @param password
     * @return
     */
    public boolean login(String account,String password);
}
