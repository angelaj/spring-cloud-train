package com.train.feign;

import com.train.feign.hystrix.RoleFeignClientHystrix;
import com.train.model.SysRole;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(value = "${app.provider}",fallback = RoleFeignClientHystrix.class)
public interface RoleFeignClient {
    @RequestMapping(value = "/api/role/getRoleListByUser", method = RequestMethod.POST)
    Map<String,Object> getRoleListByUser(@RequestBody Map<String, Object> param);

    @RequestMapping(value = "/api/role/getRoleList", method = RequestMethod.POST)
    Map<String,Object> getRoleList(@RequestBody Map<String, Object> param);

    @RequestMapping(value = "/api/role/getByRoleId", method = RequestMethod.GET)
    Map<String,Object> getByRoleId(@RequestParam("roleId") Long roleId);

    @RequestMapping(value = "/api/role/saveRole", method = RequestMethod.POST)
    Map<String,Object> saveRole(@RequestBody SysRole sysRole);
}
