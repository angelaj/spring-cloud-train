package com.train.feign;

import com.train.feign.hystrix.UserFeignClientHystrix;
import com.train.model.SysUser;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(value = "${app.provider}",fallback = UserFeignClientHystrix.class)
public interface UserFeignClient {
    @RequestMapping(value = "/api/user/getByLoginName", method = RequestMethod.GET)
    Map<String,Object> getByLoginName(@RequestParam("loginName") String loginName);

    @RequestMapping(value = "/api/user/getUserListByRole", method = RequestMethod.POST)
    Map<String,Object> getUserListByRole(@RequestBody Map<String, Object> param);

    @RequestMapping(value = "/api/user/updateUserByMap", method = RequestMethod.POST)
    Map<String,Object> updateUserByMap(@RequestBody Map<String, Object> param);

    @RequestMapping(value = "/api/user/getByUserId", method = RequestMethod.GET)
    Map<String,Object> getByUserId(@RequestParam("userId") Long userId);

    @RequestMapping(value = "/api/user/saveUser", method = RequestMethod.POST)
    Map<String,Object> saveUser(@RequestBody SysUser sysUser);
}
