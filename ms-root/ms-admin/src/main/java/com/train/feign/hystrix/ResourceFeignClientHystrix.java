package com.train.feign.hystrix;

import com.train.common.constant.ResultCode;
import com.train.common.utils.ResultGenerator;
import com.train.feign.ResourceFeignClient;
import com.train.model.SysResource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Map;

@Component
public class ResourceFeignClientHystrix implements ResourceFeignClient {
    @Override
    public Map<String, Object> getResourceListByRole(Map<String, Object> param) {
        Map<String,Object> result = ResultGenerator.getFailMap(ResultCode.CODE_FAIL.getCode(),"调用接口失败！");
        result.put("total",0);
        result.put("list",new ArrayList<SysResource>());
        return result;
    }

    @Override
    public Map<String, Object> getResourceTreeByUserId(Long userId) {
        Map<String,Object> result = ResultGenerator.getFailMap(ResultCode.CODE_FAIL.getCode(),"调用接口失败！");
        result.put("total",0);
        result.put("tree",new ArrayList<SysResource>());
        return result;
    }

    @Override
    public Map<String, Object> getResourceListByUser(Map<String, Object> param) {
        Map<String,Object> result = ResultGenerator.getFailMap(ResultCode.CODE_FAIL.getCode(),"调用接口失败！");
        result.put("total",0);
        result.put("list",new ArrayList<SysResource>());
        return result;
    }

    @Override
    public Map<String, Object> getResourceList(Map<String, Object> param) {
        Map<String,Object> result = ResultGenerator.getFailMap(ResultCode.CODE_FAIL.getCode(),"调用接口失败！");
        result.put("total",0);
        result.put("list",new ArrayList<SysResource>());
        return result;
    }

    @Override
    public Map<String, Object> getByResourceId(Long resourceId) {
        Map<String,Object> result = ResultGenerator.getFailMap(ResultCode.CODE_FAIL.getCode(),"调用接口失败！");
        result.put("data",null);
        return result;
    }

    @Override
    public Map<String, Object> saveResource(SysResource sysResource) {
        Map<String,Object> result = ResultGenerator.getFailMap(ResultCode.CODE_FAIL.getCode(),"调用接口失败！");
        return result;
    }
}
