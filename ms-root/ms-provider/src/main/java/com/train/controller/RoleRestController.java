package com.train.controller;

import com.train.common.constant.ResultCode;
import com.train.common.util.ObjectUtil;
import com.train.common.util.StrUtil;
import com.train.common.utils.ResultGenerator;
import com.train.model.SysRole;
import com.train.model.vo.SysRoleVo;
import com.train.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/role")
public class RoleRestController {
    @Autowired
    IRoleService roleService;

    @RequestMapping(value="/getRoleListByUser",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getRoleListByUser(@RequestBody Map<String,Object> param) {
        Long userId = ObjectUtil.toLong(param.get("userId"));
        String roleIds = ObjectUtil.toString(param.get("roleIds"));
        Integer roleType = ObjectUtil.toInteger(param.get("roleType"));
        String roleName = ObjectUtil.toString(param.get("roleName"));
        Integer start = ObjectUtil.toInteger(param.get("start"));
        Integer limit = ObjectUtil.toInteger(param.get("limit"));
        String sort = ObjectUtil.toString(param.get("sort"));
        String order = ObjectUtil.toString(param.get("order"));

        Map<String,Object> result = ResultGenerator.getSuccessMap();

        Map<String,Object> reqParam = new HashMap<>();
        if (ObjectUtil.isNotNull(userId)){
            reqParam.put("userId",userId);
        }
        if (StrUtil.isNotEmpty(roleIds)){
            reqParam.put("roleIdAry",roleIds.split(","));
        }
        if (ObjectUtil.isNotNull(roleType)){
            reqParam.put("roleType",roleType);
        }
        if (StrUtil.isNotEmpty(roleName)){
            reqParam.put("roleName",roleName);
        }
        if (ObjectUtil.isNotNull(start) && ObjectUtil.isNotNull(limit)){
            reqParam.put("start",start);
            reqParam.put("limit",limit);
        }
        if (StrUtil.isNotEmpty(sort) && StrUtil.isNotEmpty(order)){
            reqParam.put("sort",sort);
            reqParam.put("order",order);
        }
        Integer total = roleService.getRoleCountByUser(reqParam);
        List<SysRole> sysRoleList = new ArrayList<>();
        if (total>0){
            sysRoleList= roleService.getRoleListByUser(reqParam);
        }
        result.put("total",total);
        result.put("list",sysRoleList);
        return result;
    }

    @RequestMapping(value="/getRoleList",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getRoleList(@RequestBody Map<String,Object> param) {
        String roleIds = ObjectUtil.toString(param.get("roleIds"));
        Integer roleType = ObjectUtil.toInteger(param.get("roleType"));
        String roleName = ObjectUtil.toString(param.get("roleName"));
        Integer start = ObjectUtil.toInteger(param.get("start"));
        Integer limit = ObjectUtil.toInteger(param.get("limit"));
        String sort = ObjectUtil.toString(param.get("sort"));
        String order = ObjectUtil.toString(param.get("order"));

        Map<String,Object> result = ResultGenerator.getSuccessMap();

        Map<String,Object> reqParam = new HashMap<>();
        if (StrUtil.isNotEmpty(roleIds)){
            reqParam.put("roleIdAry",roleIds.split(","));
        }
        if (ObjectUtil.isNotNull(roleType)){
            reqParam.put("roleType",roleType);
        }
        if (StrUtil.isNotEmpty(roleName)){
            reqParam.put("roleName",roleName);
        }
        if (ObjectUtil.isNotNull(start) && ObjectUtil.isNotNull(limit)){
            reqParam.put("start",start);
            reqParam.put("limit",limit);
        }
        if (StrUtil.isNotEmpty(sort) && StrUtil.isNotEmpty(order)){
            reqParam.put("sort",sort);
            reqParam.put("order",order);
        }
        Integer total = roleService.getRoleCount(reqParam);
        List<SysRole> sysRoleList= roleService.getRoleList(reqParam);
        result.put("total",total);
        result.put("list",sysRoleList);
        return result;
    }

    @RequestMapping(value = "/getByRoleId", method = RequestMethod.GET)
    Map<String,Object> getByRoleId(@RequestParam("roleId") Long roleId){
        Map<String,Object> result = ResultGenerator.getSuccessMap();
        SysRoleVo sysRoleVo = roleService.getRoleDetail(roleId);
        if (sysRoleVo ==null){
            result = ResultGenerator.getFailMap(ResultCode.CODE_FAIL.getCode(),"数据为空！");
        }
        result.put("data",sysRoleVo);
        return result;
    }

    @RequestMapping(value = "/saveRole", method = RequestMethod.POST)
    Map<String,Object> saveRole(@RequestBody SysRoleVo sysRole){
        Map<String,Object> result = ResultGenerator.getSuccessMap();

        String errMsg = roleService.saveRole(sysRole);
        if (StrUtil.isNotEmpty(errMsg)){
            result = ResultGenerator.getFailMap(ResultCode.CODE_FAIL.getCode(), errMsg);
        }
        return result;
    }
}
