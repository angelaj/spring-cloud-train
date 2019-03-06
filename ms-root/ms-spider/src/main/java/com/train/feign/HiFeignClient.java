package com.train.feign;

import com.train.feign.hystrix.HiFeignClientHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "ms-provider",fallback = HiFeignClientHystrix.class)
public interface HiFeignClient {
    @GetMapping(value ="/sayHi")
    public String sayHi(@RequestParam("name") String name);
}
