package com.kiko.nacos.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 调用远程接口
 */
@FeignClient("service-provider")
public interface ServiceProviderClient {
    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    String hello();
}