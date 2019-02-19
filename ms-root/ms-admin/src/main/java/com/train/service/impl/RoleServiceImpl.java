package com.train.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.train.common.constant.ResultCode;
import com.train.common.util.ObjectUtil;
import com.train.feign.RoleFeignClient;
import com.train.model.SysRole;
import com.train.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    RoleFeignClient roleFeignClient;

    @Override
    public Integer getRoleCountByUser(Map<String, Object> params) {
        Map<String,Object> resultMap = roleFeignClient.getRoleListByUser(params);
        if (resultMap!=null && resultMap.get("rsCode").equals(ResultCode.CODE_SUCCESS.getCode())){
            Integer total = ObjectUtil.toInteger(resultMap.get("total"));
            return total;
        }
        return 0;
    }

    @Override
    public List<SysRole> getRoleListByUser(Map<String, Object> params) {
        Map<String,Object> resultMap = roleFeignClient.getRoleListByUser(params);
        if (resultMap!=null && resultMap.get("rsCode").equals(ResultCode.CODE_SUCCESS.getCode())){
            Object listObj = resultMap.get("list");
            String listObjStr = JSONObject.toJSONString(listObj);
            List<SysRole> sysRoleList = JSONObject.parseArray(listObjStr, SysRole.class);
            return sysRoleList;
        }
        return null;
    }

    @Override
    public Integer getRoleCount(Map<String, Object> params) {
        Map<String,Object> resultMap = roleFeignClient.getRoleList(params);
        if (resultMap!=null && resultMap.get("rsCode").equals(ResultCode.CODE_SUCCESS.getCode())){
            Integer total = ObjectUtil.toInteger(resultMap.get("total"));
            return total;
        }
        return 0;
    }

    @Override
    public List<SysRole> getRoleList(Map<String, Object> params) {
        Map<String,Object> resultMap = roleFeignClient.getRoleList(params);
        if (resultMap!=null && resultMap.get("rsCode").equals(ResultCode.CODE_SUCCESS.getCode())){
            Object listObj = resultMap.get("list");
            String listObjStr = JSONObject.toJSONString(listObj);
            List<SysRole> sysRoleList = JSONObject.parseArray(listObjStr, SysRole.class);
            return sysRoleList;
        }
        return null;
    }

    @Override
    public Map<String, Object> getRoleListMap(Map<String, Object> params) {
        Map<String,Object> result = new HashMap<>();
        Integer total = 0;
        List<SysRole> sysRoleList = new ArrayList<>();

        Map<String,Object> resultMap = roleFeignClient.getRoleList(params);
        if (resultMap!=null && resultMap.get("rsCode").equals(ResultCode.CODE_SUCCESS.getCode())){
            total = ObjectUtil.toInteger(resultMap.get("total"));
            Object listObj = resultMap.get("list");
            String listObjStr = JSONObject.toJSONString(listObj);
            sysRoleList = JSONObject.parseArray(listObjStr, SysRole.class);
        }

        result.put("total",total);
        result.put("list",sysRoleList);
        return result;
    }

    @Override
    public SysRole getRoleDetail(Long roleId) {
        Map<String, Object> resultMap = roleFeignClient.getByRoleId(roleId);
        if (resultMap != null && resultMap.get("rsCode").equals(ResultCode.CODE_SUCCESS.getCode())) {
            Object dataObj = resultMap.get("data");
            String dataStr = JSONObject.toJSONString(dataObj);
            SysRole sysRole = JSONObject.parseObject(dataStr, SysRole.class);
            return sysRole;
        }

        return null;
    }

    @Override
    public String saveRole(SysRole sysRole) {
        String errMsg = "";
        Map<String,Object> resultMap = roleFeignClient.saveRole(sysRole);
        if (resultMap==null){
            errMsg += "返回结果为空！";
        }else if(!resultMap.get("rsCode").equals(ResultCode.CODE_SUCCESS.getCode())){
            errMsg += resultMap.get("rsMsg");
        }

        return errMsg;
    }
}
