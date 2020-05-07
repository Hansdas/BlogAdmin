package com.blog.cms.web.Intreceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class InterceptConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LoginInterceptor loginInterceptor=new LoginInterceptor();
        InterceptorRegistration loginRegistry=registry.addInterceptor(loginInterceptor);
        loginRegistry.addPathPatterns("/api/**");
    }
}
