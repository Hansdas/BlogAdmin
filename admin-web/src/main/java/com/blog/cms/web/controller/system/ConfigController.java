package com.blog.cms.web.controller.system;

import com.blog.cms.common.JsonResult;
import com.blog.cms.common.constant.ConfigKey;
import com.blog.cms.domain.system.config.MailConfig;
import com.blog.cms.service.system.IConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/config")
public class ConfigController {
    @Autowired
    private IConfigService configService;
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
}
