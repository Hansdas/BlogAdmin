package com.blog.cms.web.Intreceptor;

import com.blog.cms.common.constant.SessionKey;
import com.blog.cms.common.exception.LoginException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession httpSession=request.getSession();
        Object sessionValue= httpSession.getAttribute(SessionKey.AUTH_USER);
        if (sessionValue!=null)
            return true;
        throw new LoginException();
    }
}
