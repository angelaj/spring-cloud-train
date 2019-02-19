package com.train.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.train.common.constant.ResultCode;
import com.train.common.util.ObjectUtil;
import com.train.feign.ResourceFeignClient;
import com.train.model.SysResource;
import com.train.service.IResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ResourceServiceImpl implements IResourceService {
    @Autowired
    ResourceFeignClient resourceFeignClient;

    @Override
    public Integer getResourceCountByUser(Map<String, Object> reqParams) {
        Map<String,Object> resultMap = resourceFeignClient.getResourceListByUser(reqParams);
        if (resultMap!=null && resultMap.get("rsCode").equals(ResultCode.CODE_SUCCESS.getCode())){
            Integer total = ObjectUtil.toInteger(resultMap.get("total"));
            return total;
        }
        return 0;
    }

    @Override
    public List<SysResource> getResourceListByUser(Map<String, Object> reqParams) {
        Map<String,Object> resultMap = resourceFeignClient.getResourceListByUser(reqParams);
        if (resultMap!=null && resultMap.get("rsCode").equals(ResultCode.CODE_SUCCESS.getCode())){
            Object listObj = resultMap.get("list");
            String listObjStr = JSONObject.toJSONString(listObj);
            List<SysResource> sysResourcesList = JSONObject.parseArray(listObjStr, SysResource.class);
            return sysResourcesList;
        }
        return null;
    }

    @Override
    public List<SysResource> getResourceTreeByUserId(Long userId) {
        Map<String,Object> resultMap = resourceFeignClient.getResourceTreeByUserId(userId);
        if (resultMap!=null && resultMap.get("rsCode").equals(ResultCode.CODE_SUCCESS.getCode())){
            Object listObj = resultMap.get("tree");
            String listObjStr = JSONObject.toJSONString(listObj);
            List<SysResource> sysResourcesList = JSONObject.parseArray(listObjStr, SysResource.class);
            return sysResourcesList;
        }
        return null;
    }

    @Override
    public List<SysResource> getAllResourceList() {
        Map<String,Object> reqParams = new HashMap<>();
        Map<String,Object> resultMap = resourceFeignClient.getResourceList(reqParams);
        if (resultMap!=null && resultMap.get("rsCode").equals(ResultCode.CODE_SUCCESS.getCode())){
            Object listObj = resultMap.get("list");
            String listObjStr = JSONObject.toJSONString(listObj);
            List<SysResource> sysResourcesList = JSONObject.parseArray(listObjStr, SysResource.class);
            return sysResourcesList;
        }
        return null;
    }

    @Override
    public Integer getResourceCountByRole(Map<String, Object> reqParams) {
        Map<String,Object> resultMap = resourceFeignClient.getResourceListByRole(reqParams);
        if (resultMap!=null && resultMap.get("rsCode").equals(ResultCode.CODE_SUCCESS.getCode())){
            Integer total = ObjectUtil.toInteger(resultMap.get("total"));
            return total;
        }
        return 0;
    }

    @Override
    public List<SysResource> getResourceListByRole(Map<String, Object> reqParams) {
        Map<String,Object> resultMap = resourceFeignClient.getResourceListByRole(reqParams);
        if (resultMap!=null && resultMap.get("rsCode").equals(ResultCode.CODE_SUCCESS.getCode())){
            Object listObj = resultMap.get("list");
            String listObjStr = JSONObject.toJSONString(listObj);
            List<SysResource> sysResourcesList = JSONObject.parseArray(listObjStr, SysResource.class);
            return sysResourcesList;
        }
        return null;
    }

    @Override
    public Integer getResourceCount(Map<String, Object> reqParams) {
        Map<String,Object> resultMap = resourceFeignClient.getResourceList(reqParams);
        if (resultMap!=null && resultMap.get("rsCode").equals(ResultCode.CODE_SUCCESS.getCode())){
            Integer total = ObjectUtil.toInteger(resultMap.get("total"));
            return total;
        }
        return 0;
    }

    @Override
    public List<SysResource> getResourceList(Map<String, Object> reqParams) {
        Map<String,Object> resultMap = resourceFeignClient.getResourceList(reqParams);
        if (resultMap!=null && resultMap.get("rsCode").equals(ResultCode.CODE_SUCCESS.getCode())){
            Object listObj = resultMap.get("list");
            String listObjStr = JSONObject.toJSONString(listObj);
            List<SysResource> sysResourcesList = JSONObject.parseArray(listObjStr, SysResource.class);
            return sysResourcesList;
        }
        return null;
    }

    @Override
    public Map<String,Object> getResourceListMap(Map<String, Object> reqParams) {
        Map<String,Object> result = new HashMap<>();
        Integer total = 0;
        List<SysResource> sysResourcesList = new ArrayList<>();

        Map<String,Object> resultMap = resourceFeignClient.getResourceList(reqParams);
        if (resultMap!=null && resultMap.get("rsCode").equals(ResultCode.CODE_SUCCESS.getCode())){
            total = ObjectUtil.toInteger(resultMap.get("total"));
            Object listObj = resultMap.get("list");
            String listObjStr = JSONObject.toJSONString(listObj);
            sysResourcesList = JSONObject.parseArray(listObjStr, SysResource.class);
        }

        result.put("total",total);
        result.put("list",sysResourcesList);
        return result;
    }

    @Override
    public SysResource getResourceDetail(Long resourceId) {
        Map<String,Object> resultMap = resourceFeignClient.getByResourceId(resourceId);
        if (resultMap!=null && resultMap.get("rsCode").equals(ResultCode.CODE_SUCCESS.getCode())) {
            Object dataObj = resultMap.get("data");
            String dataStr = JSONObject.toJSONString(dataObj);
            SysResource sysResource = JSONObject.parseObject(dataStr, SysResource.class);
            return sysResource;
        }

        return null;
    }

    @Override
    public String saveResource(SysResource sysResource) {
        String errMsg = "";
        Map<String,Object> resultMap = resourceFeignClient.saveResource(sysResource);
        if (resultMap==null){
            errMsg += "返回结果为空！";
        }else if(!resultMap.get("rsCode").equals(ResultCode.CODE_SUCCESS.getCode())){
            errMsg += resultMap.get("rsMsg");
        }

        return errMsg;
    }
}
