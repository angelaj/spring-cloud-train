package com.train.service;

import com.train.model.SysUser;
import com.train.model.vo.SysUserVo;

import java.util.List;
import java.util.Map;

public interface IUserService{
	SysUser getByLoginName(String userName);

	SysUserVo getByUserId(Long userId);

	Integer getUserCountByRole(Map<String, Object> param);

	List<SysUser> getUserListByRole(Map<String, Object> param);

	String updateUserByMap(Map<String, Object> param);

	String saveUser(SysUserVo sysUserVo);
}
