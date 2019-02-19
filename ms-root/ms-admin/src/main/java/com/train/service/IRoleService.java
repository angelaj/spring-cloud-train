package com.train.service;

import com.train.model.SysRole;

import java.util.List;
import java.util.Map;

public interface IRoleService{
    Integer getRoleCountByUser(Map<String, Object> params);

    List<SysRole> getRoleListByUser(Map<String, Object> params);

    Integer getRoleCount(Map<String, Object> params);

    List<SysRole> getRoleList(Map<String, Object> params);

    Map<String,Object> getRoleListMap(Map<String, Object> params);

    SysRole getRoleDetail(Long roleId);

    String saveRole(SysRole sysRole);
}
