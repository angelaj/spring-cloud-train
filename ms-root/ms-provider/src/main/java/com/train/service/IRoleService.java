package com.train.service;

import com.train.model.SysRole;
import com.train.model.vo.SysRoleVo;

import java.util.List;
import java.util.Map;

public interface IRoleService{
    Integer getRoleCountByUser(Map<String, Object> params);

    List<SysRole> getRoleListByUser(Map<String, Object> params);

    Integer getRoleCount(Map<String, Object> params);

    List<SysRole> getRoleList(Map<String, Object> params);

    SysRoleVo getRoleDetail(Long roleId);

    String saveRole(SysRoleVo sysRoleVo);
}
