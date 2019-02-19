package com.train.feign.hystrix;

import com.train.feign.HiFeignClient;
import org.springframework.stereotype.Component;

@Component
public class HiFeignClientHystrix implements HiFeignClient {
    @Override
    public String sayHi(String name) {
        return "sorry,"+name;
    }
}
