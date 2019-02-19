package com.train.service;

import com.train.model.SysUser;

import java.util.Map;

public interface IUserService{
	SysUser getByLoginName(String loginName);

	Map<String,Object> getUserListMap(Map<String, Object> param);

	String updateUserByMap(Map<String, Object> param);

	SysUser getUserDetail(Long userId);

	String saveUser(SysUser sysUser);
}
