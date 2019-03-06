package com.train.feign.hystrix;

import com.train.feign.IconFeignClient;
import com.train.model.Icon;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class IconFeignClientHystrix implements IconFeignClient {
    @Override
    public Map<String, Object> save(Icon icon) {
        return null;
    }
}
