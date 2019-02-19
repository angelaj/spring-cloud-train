package com.train.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.train.common.constant.ResultCode;
import com.train.common.util.ObjectUtil;
import com.train.feign.UserFeignClient;
import com.train.model.SysUser;
import com.train.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	UserFeignClient userFeignClient;

	@Override
	public SysUser getByLoginName(String loginName) {
		Map<String,Object> resultMap = userFeignClient.getByLoginName(loginName);
		if (resultMap!=null && resultMap.get("rsCode").equals(ResultCode.CODE_SUCCESS.getCode())) {
			Object dataObj = resultMap.get("data");
			String dataStr = JSONObject.toJSONString(dataObj);
			SysUser sysUser = JSONObject.parseObject(dataStr, SysUser.class);
			return sysUser;
		}

		return null;
	}

	@Override
	public Map<String,Object> getUserListMap(Map<String, Object> param) {
		Map<String,Object> result = new HashMap<>();
		Integer total = 0;
		List<SysUser> sysUserList = new ArrayList<>();

		Map<String,Object> resultMap = userFeignClient.getUserListByRole(param);
		if (resultMap!=null && resultMap.get("rsCode").equals(ResultCode.CODE_SUCCESS.getCode())){
			total = ObjectUtil.toInteger(resultMap.get("total"));
			Object listObj = resultMap.get("list");
			String listObjStr = JSONObject.toJSONString(listObj);
			sysUserList = JSONObject.parseArray(listObjStr, SysUser.class);
		}

		result.put("total",total);
		result.put("list",sysUserList);
		return result;
	}

	@Override
	public String updateUserByMap(Map<String, Object> param) {
		String errMsg = "";
		Map<String,Object> resultMap = userFeignClient.updateUserByMap(param);
		if (resultMap==null){
			errMsg += "返回结果为空！";
		}else if(!resultMap.get("rsCode").equals(ResultCode.CODE_SUCCESS.getCode())){
			errMsg += resultMap.get("rsMsg");
		}

		return errMsg;
	}

	@Override
	public SysUser getUserDetail(Long userId) {
		Map<String,Object> resultMap = userFeignClient.getByUserId(userId);
		if (resultMap!=null && resultMap.get("rsCode").equals(ResultCode.CODE_SUCCESS.getCode())) {
			Object dataObj = resultMap.get("data");
			String dataStr = JSONObject.toJSONString(dataObj);
			SysUser sysUser = JSONObject.parseObject(dataStr, SysUser.class);
			return sysUser;
		}

		return null;
	}

	@Override
	public String saveUser(SysUser sysUser) {
		String errMsg = "";
		Map<String,Object> resultMap = userFeignClient.saveUser(sysUser);
		if (resultMap==null){
			errMsg += "返回结果为空！";
		}else if(!resultMap.get("rsCode").equals(ResultCode.CODE_SUCCESS.getCode())){
			errMsg += resultMap.get("rsMsg");
		}

		return errMsg;
	}
}
