package com.train.feign;

import com.train.feign.hystrix.IconFeignClientHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@FeignClient(value = "${app.provider}",fallback = IconFeignClientHystrix.class)
public interface IconFeignClient {
    @RequestMapping(value = "/api/icon/getIconList", method = RequestMethod.POST)
    Map<String,Object> getIconList(@RequestBody Map<String, Object> param);
}
