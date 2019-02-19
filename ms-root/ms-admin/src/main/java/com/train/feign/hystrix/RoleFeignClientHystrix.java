package com.train.feign.hystrix;

import com.train.common.constant.ResultCode;
import com.train.common.utils.ResultGenerator;
import com.train.feign.RoleFeignClient;
import com.train.model.SysRole;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Map;

@Component
public class RoleFeignClientHystrix implements RoleFeignClient {
    @Override
    public Map<String, Object> getRoleListByUser(Map<String, Object> param) {
        Map<String,Object> result = ResultGenerator.getFailMap(ResultCode.CODE_FAIL.getCode(),"调用接口失败！");
        result.put("total",0);
        result.put("list",new ArrayList<SysRole>());
        return result;
    }

    @Override
    public Map<String, Object> getRoleList(Map<String, Object> param) {
        Map<String,Object> result = ResultGenerator.getFailMap(ResultCode.CODE_FAIL.getCode(),"调用接口失败！");
        result.put("total",0);
        result.put("list",new ArrayList<SysRole>());
        return result;
    }

    @Override
    public Map<String, Object> getByRoleId(Long roleId) {
        Map<String,Object> result = ResultGenerator.getFailMap(ResultCode.CODE_FAIL.getCode(),"调用接口失败！");
        result.put("data",null);
        return result;
    }

    @Override
    public Map<String, Object> saveRole(SysRole sysRole) {
        Map<String,Object> result = ResultGenerator.getFailMap(ResultCode.CODE_FAIL.getCode(),"调用接口失败！");
        return result;
    }
}
