package com.train.feign;

import com.train.feign.hystrix.ResourceFeignClientHystrix;
import com.train.model.SysResource;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(value = "${app.provider}",fallback = ResourceFeignClientHystrix.class)
public interface ResourceFeignClient {
    @RequestMapping(value = "/api/resource/getResourceListByRole", method = RequestMethod.POST)
    Map<String,Object> getResourceListByRole(@RequestBody Map<String, Object> param);

    @RequestMapping(value = "/api/resource/getResourceTreeByUserId", method = RequestMethod.GET)
    Map<String,Object> getResourceTreeByUserId(@RequestParam("userId") Long userId);

    @RequestMapping(value = "/api/resource/getResourceListByUser", method = RequestMethod.POST)
    Map<String,Object> getResourceListByUser(@RequestBody Map<String, Object> param);

    @RequestMapping(value = "/api/resource/getResourceList", method = RequestMethod.POST)
    Map<String,Object> getResourceList(@RequestBody Map<String, Object> param);

    @RequestMapping(value = "/api/resource/getByResourceId", method = RequestMethod.GET)
    Map<String,Object> getByResourceId(@RequestParam("resourceId") Long resourceId);

    @RequestMapping(value = "/api/resource/saveResource", method = RequestMethod.POST)
    Map<String,Object> saveResource(@RequestBody SysResource sysResource);
}
