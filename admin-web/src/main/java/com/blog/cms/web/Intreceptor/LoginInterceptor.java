package com.blog.cms.web.Intreceptor;

import com.blog.cms.common.constant.SessionKey;
import com.blog.cms.common.exception.LoginException;
import com.blog.cms.web.webservice.CreateTaskByNOP;
import com.blog.cms.web.webservice.CreateTaskByNOPSoap;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("接收到请求");
       /* CreateTaskByNOP createTaskByNOP=new CreateTaskByNOP();
        CreateTaskByNOPSoap soap=createTaskByNOP.getCreateTaskByNOPSoap();
        String xml="<opDetail><recordInfo><fieldInfo><fieldChName>项目编号</fieldChName><fieldEnName" +
                ">T_ProjectNumber</fieldEnName><fieldContent>B19304010000582</fieldContent></fiel" +
                "dInfo><fieldInfo><fieldChName>任务编号</fieldChName><fieldEnName>T_Number</field" +
                "EnName><fieldContent>29.001</fieldContent></fieldInfo><fieldInfo><fieldChName>任" +
                "务名称</fieldChName><fieldEnName>T_Name</fieldEnName><fieldContent>2019年宝塔区" +
                "延长油田股份有限公司南泥湾采油厂强尧南66井站数据专线</fieldContent></fieldInfo><" +
                "fieldInfo><fieldChName>工单流水号</fieldChName><fieldEnName>T_State</fieldEnName" +
                "><fieldContent>WF045049000000169</fieldContent></fieldInfo><fieldInfo><fieldChNa" +
                "me>CRMNO</fieldChName><fieldEnName>T_CRMNumber</fieldEnName><fieldContent>GRP201" +
                "9112509998957</fieldContent></fieldInfo></recordInfo></opDetail>";
         String result= soap.insertTask(xml);*/
        HttpSession httpSession=request.getSession();
        Object sessionValue= httpSession.getAttribute(SessionKey.AUTH_USER);
        if (sessionValue!=null)
            return true;
        return true;
        //throw  new LoginException("未登录");
    }
}
