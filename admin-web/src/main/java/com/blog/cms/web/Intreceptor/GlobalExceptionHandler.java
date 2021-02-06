package com.blog.cms.web.Intreceptor;

import com.blog.cms.common.JsonResult;
import com.blog.cms.common.exception.LoginException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public JsonResult exceptionHandler(HttpServletRequest request,Exception e){
        if (e instanceof LoginException)
            return JsonResult.Error("not login");
        String message=  e.getMessage();
        return JsonResult.Error(message);
    }
}
