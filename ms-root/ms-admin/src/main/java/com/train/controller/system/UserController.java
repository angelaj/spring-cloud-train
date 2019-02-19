package com.train.controller.system;

import com.train.common.constant.ResultCode;
import com.train.common.util.ObjectUtil;
import com.train.common.util.StrUtil;
import com.train.common.utils.ResultGenerator;
import com.train.model.SysUser;
import com.train.service.IRoleService;
import com.train.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/system/user")
public class UserController {

	@Autowired
	private IUserService userService;

	@Autowired
	private IRoleService roleService;

	@GetMapping("/manager")
	public String manager() {
		return "system/user";
	}

	@GetMapping("/getUserList")
	@ResponseBody
	public Map<String,Object> getUserList(@RequestParam Map<String, Object> params) {
		String userIds = ObjectUtil.toString(params.get("userIds"));
		String loginName = ObjectUtil.toString(params.get("loginName"));
		String userName = ObjectUtil.toString(params.get("userName"));
		Long roleId = ObjectUtil.toLong(params.get("roleId"));
		Integer state = ObjectUtil.toInteger(params.get("state"));
		Integer start = ObjectUtil.toInteger(params.get("start"));
		Integer limit = ObjectUtil.toInteger(params.get("limit"));
		String sort = ObjectUtil.toString(params.get("sort"));
		String order = ObjectUtil.toString(params.get("order"));

		Map<String,Object> reqParam = new HashMap<>();
		if (StrUtil.isNotEmpty(userIds)){
			reqParam.put("userIds",userIds);
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

		Integer total = 0;
		List<SysUser> sysUserList = new ArrayList<>();
		Map<String,Object> result = userService.getUserListMap(reqParam);
		if (result!=null){
			total = ObjectUtil.toInteger(result.get("total"));
			sysUserList = (List<SysUser>)result.get("list");
		}

		Map<String,Object> resultMap= ResultGenerator.getSuccessMap();
		resultMap.put("total", total);
		resultMap.put("rows", sysUserList);
		return resultMap;
	}

	@GetMapping("/updateUserStatusBatch")
	@ResponseBody
	public Map<String,Object> updateUserStatusBatch(@RequestParam Map<String, Object> params) {
		String userIdAry = ObjectUtil.toString(params.get("userIdAry"));
		Integer state = ObjectUtil.toInteger(params.get("state"));
		if (StrUtil.isEmpty(userIdAry)|| ObjectUtil.isNull(state)){
			return ResultGenerator.getFailMap(ResultCode.CODE_FAIL.getCode(),"参数不能为空！");
		}

		Map<String,Object> reqParam = new HashMap<>();
		reqParam.put("userIdAry",userIdAry.split(","));
		reqParam.put("toState",state);
		String errMsg = userService.updateUserByMap(reqParam);
		if (StrUtil.isNotEmpty(errMsg)){
			return ResultGenerator.getFailMap(ResultCode.CODE_FAIL.getCode(),errMsg);
		}

		return ResultGenerator.getSuccessMap();
	}

	@GetMapping("/getUserDetail")
	@ResponseBody
	public Map<String,Object> getUserDetail(Long id) {
		SysUser sysUser = userService.getUserDetail(id);

		if (ObjectUtil.isNull(sysUser)){
			return ResultGenerator.getFailMap(ResultCode.CODE_FAIL.getCode(),"数据为空！");
		}

		Map<String,Object> result = ResultGenerator.getSuccessMap();
		result.put("data", sysUser);
		return result;
	}

	@PostMapping("/saveUser")
	@ResponseBody
	public Map<String,Object> saveUser(SysUser sysUser) {
		String errMsg= userService.saveUser(sysUser);
		if (StrUtil.isNotEmpty(errMsg)){
			return ResultGenerator.getFailMap(ResultCode.CODE_FAIL.getCode(),errMsg);
		}

		return ResultGenerator.getSuccessMap();
	}
}
