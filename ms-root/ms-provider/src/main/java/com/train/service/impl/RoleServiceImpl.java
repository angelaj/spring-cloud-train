package com.train.service.impl;

import com.train.mapper.SysRoleMapper;
import com.train.mapper.SysRoleResourceMapper;
import com.train.model.SysResource;
import com.train.model.SysRole;
import com.train.model.vo.SysRoleVo;
import com.train.service.IResourceService;
import com.train.service.IRoleService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    SysRoleMapper sysRoleMapper;

    @Autowired
    IResourceService resourceService;

    @Autowired
    SysRoleResourceMapper sysRoleResourceMapper;

    @Override
    public Integer getRoleCountByUser(Map<String, Object> params) {
        return sysRoleMapper.getRoleCountByUser(params);
    }

    @Override
    public List<SysRole> getRoleListByUser(Map<String, Object> params) {
        return sysRoleMapper.getRoleListByUser(params);
    }

    @Override
    public Integer getRoleCount(Map<String, Object> params) {
        return sysRoleMapper.getRoleCount(params);
    }

    @Override
    public List<SysRole> getRoleList(Map<String, Object> params) {
        return sysRoleMapper.getRoleList(params);
    }

    @Override
    public SysRoleVo getRoleDetail(Long roleId) {
        SysRoleVo sysRoleVo = sysRoleMapper.getRoleById(roleId);
        if (sysRoleVo != null){
            Map<String,Object> param = new HashMap<>();
            param.put("roleId",roleId);
            List<SysResource> sysResourceList = resourceService.getResourceListByRole(param);
            sysRoleVo.setRoleResourceList(sysResourceList);
        }
        return sysRoleVo;
    }

    @Transactional
    @Override
    public String saveRole(SysRoleVo sysRoleVo) {
        Long roleId = sysRoleVo.getId();
        //新增或更新
        if (roleId == null){//新增
            sysRoleVo.setCreateTime(new Date());
            sysRoleVo.setUpdateTime(new Date());
            sysRoleMapper.insertRole(sysRoleVo);
            roleId=sysRoleVo.getId();
        }else {
            sysRoleVo.setUpdateTime(new Date());
            sysRoleMapper.updateRole(sysRoleVo);
        }

        Map<String,Object> param = new HashMap<>();
        param.put("roleId",sysRoleVo.getId());
        sysRoleResourceMapper.deleteRoleResourceBatch(param);

        if (StringUtils.isNotEmpty(sysRoleVo.getRoleResources())){
            String[] roleResourceAry = sysRoleVo.getRoleResources().split(",");
            for (String roleResourceId: roleResourceAry){
                Long resourceId = Long.parseLong(roleResourceId);
                sysRoleResourceMapper.addRoleResource(roleId,resourceId);
            }
        }

        return "";
    }
}
