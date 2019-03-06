package com.train.feign;

import com.train.feign.hystrix.IconFeignClientHystrix;
import com.train.model.Icon;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@FeignClient(value = "ms-provider",fallback = IconFeignClientHystrix.class)
public interface IconFeignClient {
    @PostMapping(value ="/api/icon/save")
    Map<String,Object> save(@RequestBody Icon icon);
}
