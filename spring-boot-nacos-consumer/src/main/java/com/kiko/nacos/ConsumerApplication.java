package com.kiko.nacos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
* @program: spring-boot-nacos-demo
* @ClassName ConsumerApplication
* @description: 
* @author: leiyt
* @create: 2024-11-28 14:54
* @Version 1.0
**/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}

@FeignClient("service-provider")
interface ServiceProviderClient {
    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    String hello();
}

@RestController
class TestController {
    @Autowired
    private ServiceProviderClient serviceProviderClient;

    @GetMapping("/consume")
    public String consume() {
        return serviceProviderClient.hello();
    }
}