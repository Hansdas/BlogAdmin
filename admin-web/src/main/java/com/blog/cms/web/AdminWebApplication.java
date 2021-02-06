package com.blog.cms.web;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication(scanBasePackages = {"com.blog.cms", "com.blog.cms.web"})
@EnableScheduling
@ServletComponentScan
@EnableTransactionManagement(proxyTargetClass = true)
public class AdminWebApplication {
    public static void main(String[] args) {

        SpringApplication.run(AdminWebApplication.class, args);
    }

}
