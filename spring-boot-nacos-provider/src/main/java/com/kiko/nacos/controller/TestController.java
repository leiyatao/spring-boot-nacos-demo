package com.kiko.nacos.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
* @program: spring-boot-nacos-demo
* @ClassName TestController
* @description: 
* @author: leiyt
* @create: 2024-11-29 17:55
* @Version 1.0
**/
@RestController
@RefreshScope  // 标记为支持动态刷新的配置类
public class TestController {
    // 创建日志记录器
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);
    @GetMapping("/hello")
    public String hello() {
        logger.info("服务端接口被调用"+this.getClass().getMethods()[0].getName());
        return "Hello from Service Provider";
    }

    @Value("${spring.cloud.nacos.config.namespace}")
    private String namespace;
    @GetMapping("/namespace")
    public String get(){
        return namespace;
    }

    @Value("${spring.datasource.druid.username}")
    private String dbusername;
    @GetMapping("/getdbusername")
    public String getDbusername(){
        return dbusername;
    }

    @Autowired
    private Environment environment;

    @GetMapping("/config")
    public String getConfig() {
        String datasourceUrl = environment.getProperty("spring.datasource.druid.url");
        String serverPort = environment.getProperty("spring.datasource.druid.username");

        return "Datasource URL: " + datasourceUrl + ", Server Port: " + serverPort;
    }
}