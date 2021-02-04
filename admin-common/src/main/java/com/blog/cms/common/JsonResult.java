package com.blog.cms.common;

public class JsonResult {
    private  String code;
    private  String message;
    private  Object data;
    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }
    public JsonResult(String code)
    {
        this.code=code;
    }
    public JsonResult(String code,String message)
    {
        this.code=code;
        this.message=message;
    }
    public JsonResult(String code,Object data)
    {
        this.code=code;
        this.data=data;
    }
    public JsonResult(String code,String message,Object data)
    {
        this.code=code;
        this.message=message;
        this.data=data;
    }
    public static JsonResult success(Object data){
        return new JsonResult("0",data);
    }
}
