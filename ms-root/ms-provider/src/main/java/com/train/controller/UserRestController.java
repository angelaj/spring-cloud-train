package com.train.controller;

import com.train.common.constant.ResultCode;
import com.train.common.util.ObjectUtil;
import com.train.common.util.StrUtil;
import com.train.common.utils.ResultGenerator;
import com.train.model.SysUser;
import com.train.model.vo.SysUserVo;
import com.train.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserRestController {
    @Autowired
    IUserService userService;

    @RequestMapping(value = "/getByLoginName", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getByLoginName(@RequestParam("loginName") String loginName){
        Map<String,Object> result = ResultGenerator.getSuccessMap();
        SysUser sysUser = userService.getByLoginName(loginName);
        if (sysUser ==null){
            result = ResultGenerator.getFailMap(ResultCode.CODE_FAIL.getCode(),"数据为空！");
        }
        result.put("data",sysUser);
        return result;
    }

    @RequestMapping(value = "/getUserListByRole", method = RequestMethod.POST)
    Map<String,Object> getUserListByRole(@RequestBody Map<String,Object> param){
        String userIds = ObjectUtil.toString(param.get("userIds"));
        String loginName = ObjectUtil.toString(param.get("loginName"));
        String userName = ObjectUtil.toString(param.get("userName"));
        Long roleId = ObjectUtil.toLong(param.get("roleId"));
        Integer state = ObjectUtil.toInteger(param.get("state"));
        Integer start = ObjectUtil.toInteger(param.get("start"));
        Integer limit = ObjectUtil.toInteger(param.get("limit"));
        String sort = ObjectUtil.toString(param.get("sort"));
        String order = ObjectUtil.toString(param.get("order"));

        Map<String,Object> result = ResultGenerator.getSuccessMap();
        Map<String,Object> reqParam = new HashMap<>();
        if (StrUtil.isNotEmpty(userIds)){
            reqParam.put("userIdAry",userIds.split(","));
        }
        if (StrUtil.isNotEmpty(loginName)){
            reqParam.put("loginName",loginName);
        }
        if (StrUtil.isNotEmpty(userName)){
            reqParam.put("userName",userName);
        }
        if (ObjectUtil.isNotNull(roleId)){
            reqParam.put("roleId",roleId);
        }
        if (ObjectUtil.isNotNull(state)){
            reqParam.put("state",state);
        }
        if (ObjectUtil.isNotNull(start) && ObjectUtil.isNotNull(limit)){
            reqParam.put("start",start);
            reqParam.put("limit",limit);
        }
        if (StrUtil.isNotEmpty(sort) && StrUtil.isNotEmpty(order)){
            reqParam.put("sort",sort);
            reqParam.put("order",order);
        }
        Integer total = userService.getUserCountByRole(reqParam);
        List<SysUser> sysUserList = new ArrayList<>();
        if (total>0){
            sysUserList= userService.getUserListByRole(reqParam);
        }
        result.put("total",total);
        result.put("list",sysUserList);
        return result;
    }

    @RequestMapping(value = "/updateUserByMap", method = RequestMethod.POST)
    Map<String,Object> updateUserByMap(@RequestBody Map<String,Object> param){
        Map<String,Object> result = ResultGenerator.getSuccessMap();

        String errMsg = userService.updateUserByMap(param);
        if (StrUtil.isNotEmpty(errMsg)){
            result = ResultGenerator.getFailMap(ResultCode.CODE_FAIL.getCode(), errMsg);
        }
        return result;
    }

    @RequestMapping(value="/getByUserId",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getByUserId(@RequestParam(value = "userId")  Long userId) {
        Map<String,Object> result = ResultGenerator.getSuccessMap();
        SysUserVo sysUser = userService.getByUserId(userId);
        if (sysUser ==null){
            result = ResultGenerator.getFailMap(ResultCode.CODE_FAIL.getCode(),"数据为空！");
        }
        result.put("data",sysUser);
        return result;
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    Map<String,Object> saveUser(@RequestBody SysUserVo sysUserVo){
        Map<String,Object> result = ResultGenerator.getSuccessMap();

        String errMsg = userService.saveUser(sysUserVo);
        if (StrUtil.isNotEmpty(errMsg)){
            result = ResultGenerator.getFailMap(ResultCode.CODE_FAIL.getCode(), errMsg);
        }
        return result;
    }
}
