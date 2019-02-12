package com.train.web.feign;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "ms-provider-system")
public interface HiFeignClient {
    @RequestMapping(value="/api/test/sayHi",method = RequestMethod.GET)
    String sayHi(@RequestParam(value = "name")  String name);
}
