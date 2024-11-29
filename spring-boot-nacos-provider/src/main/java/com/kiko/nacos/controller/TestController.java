package com.kiko.nacos.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* @program: spring-boot-nacos-demo
* @ClassName TestController
* @description: 
* @author: leiyt
* @create: 2024-11-29 17:55
* @Version 1.0
**/
@RestController
public class TestController {
    // 创建日志记录器
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);
    @GetMapping("/hello")
    public String hello() {
        logger.info("服务端接口被调用"+this.getClass().getMethods()[0].getName());
        return "Hello from Service Provider";
    }
}