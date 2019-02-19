package com.train.mapper;

import com.train.model.SysUser;
import com.train.model.vo.SysUserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface SysUserMapper {
    SysUser findByLoginName(@Param("loginName") String loginName);

    Integer getUserCountByRole(Map<String, Object> param);

    List<SysUser> getUserListByRole(Map<String, Object> param);

    Integer updateUserByMap(Map<String, Object> param);

    SysUserVo getUserById(@Param("id") Long id);

    Integer insertUser(SysUserVo sysUserVo);

    Integer updateUser(SysUserVo sysUserVo);
}