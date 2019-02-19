package com.train.feign.hystrix;

import com.train.common.constant.ResultCode;
import com.train.common.utils.ResultGenerator;
import com.train.feign.UserFeignClient;
import com.train.model.SysUser;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Map;

@Component
public class UserFeignClientHystrix implements UserFeignClient {
    @Override
    public Map<String, Object> getByLoginName(String loginName) {
        Map<String,Object> result = ResultGenerator.getFailMap(ResultCode.CODE_FAIL.getCode(),"调用接口失败！");
        result.put("data",null);
        return result;
    }

    @Override
    public Map<String, Object> getUserListByRole(Map<String, Object> param) {
        Map<String,Object> result = ResultGenerator.getFailMap(ResultCode.CODE_FAIL.getCode(),"调用接口失败！");
        result.put("total",0);
        result.put("list",new ArrayList<SysUser>());
        return result;
    }

    @Override
    public Map<String, Object> updateUserByMap(Map<String, Object> param) {
        Map<String,Object> result = ResultGenerator.getFailMap(ResultCode.CODE_FAIL.getCode(),"调用接口失败！");
        return result;
    }

    @Override
    public Map<String, Object> getByUserId(Long userId) {
        Map<String,Object> result = ResultGenerator.getFailMap(ResultCode.CODE_FAIL.getCode(),"调用接口失败！");
        result.put("data",null);
        return result;
    }

    @Override
    public Map<String, Object> saveUser(SysUser sysUser) {
        Map<String,Object> result = ResultGenerator.getFailMap(ResultCode.CODE_FAIL.getCode(),"调用接口失败！");
        return result;
    }
}
