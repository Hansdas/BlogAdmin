package com.blog.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {
    @RequestMapping("/")
    public String index()
    {
        return "redirect:/pages/index.html";
    }
}
