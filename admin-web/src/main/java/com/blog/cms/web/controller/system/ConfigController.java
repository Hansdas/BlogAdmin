package com.blog.cms.web.controller.system;

import com.blog.cms.common.JsonResult;
import com.blog.cms.common.constant.ConfigKey;
import com.blog.cms.domain.system.config.MailConfig;
import com.blog.cms.service.system.IConfigService;
import com.blog.cms.web.utils.CaptchCodeUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/config")
public class ConfigController {
    @Autowired
    private IConfigService configService;
    @RequestMapping(value = "mail",method = RequestMethod.GET)
    public JsonResult GetMailConfig(){
        try {
           MailConfig config= configService.SelectByKey(ConfigKey.MAIL_CONFIG_KEY,MailConfig.class);
            return new JsonResult("0",config);
        }
        catch (Exception e){
            return new JsonResult("1",e.getMessage());
        }
    }
    @RequestMapping(value = "mail/add",method = RequestMethod.POST)
    public JsonResult SaveMailConfig(@RequestBody MailConfig mailConfig){
        try {
            configService.Save(ConfigKey.MAIL_CONFIG_KEY,mailConfig);
            return new JsonResult("0");
        }
        catch (Exception e){
            return new JsonResult("1",e.getMessage());
        }
    }
    @GetMapping(path ="captch")
    public JsonResult getCaptchCode(){
        return JsonResult.success(CaptchCodeUntil.getCode());
    }
}
