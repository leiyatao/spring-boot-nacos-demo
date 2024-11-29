package com.kiko.nacos.controller;

import com.kiko.nacos.api.ServiceProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* @program: spring-boot-nacos-demo
* @ClassName TestController
* @description: 
* @author: leiyt
* @create: 2024-11-29 17:48
* @Version 1.0
**/
@RestController
public class TestController {
    @Autowired
    private ServiceProviderClient serviceProviderClient;

    @GetMapping("/consume")
    public String consume() {
        
        return serviceProviderClient.hello();
    }
}