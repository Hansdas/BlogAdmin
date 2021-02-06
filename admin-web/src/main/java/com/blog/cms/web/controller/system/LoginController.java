package com.blog.cms.web.controller.system;

import com.blog.cms.common.JsonResult;
import com.blog.cms.web.utils.CaptchCodeUntil;
import org.apache.coyote.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Path;

@RestController
public class LoginController {
    @RequestMapping(path = "/api/config/captch",method = RequestMethod.GET)
    public JsonResult  getCaptchCode() throws IOException {
        char[] code= CaptchCodeUntil.getCode();
        return JsonResult.Success(code);
    }
    @RequestMapping(path = "/api/login",method = RequestMethod.POST)
    public JsonResult login(HttpServletRequest request){
        String account=request.getParameter("account");
        String password=request.getParameter("password");

    }
}
