package com.train.controller.system;

import com.train.common.constant.ResultCode;
import com.train.common.util.ObjectUtil;
import com.train.common.util.StrUtil;
import com.train.common.utils.ResultGenerator;
import com.train.model.SysRole;
import com.train.service.IResourceService;
import com.train.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/system/role")
public class RoleController {

	@Autowired
	private IRoleService roleService;

	@Autowired
	private IResourceService resourceService;

	@GetMapping("/manager")
	public String manager() {
		return "system/role";
	}

	@GetMapping("/getRoleList")
	@ResponseBody
	public Map<String,Object> getRoleList(@RequestParam Map<String, Object> params) {
		String roleIds = ObjectUtil.toString(params.get("roleIds"));
		Integer roleType = ObjectUtil.toInteger(params.get("roleType"));
		String roleName = ObjectUtil.toString(params.get("roleName"));
		Integer start = ObjectUtil.toInteger(params.get("start"));
		Integer limit = ObjectUtil.toInteger(params.get("limit"));
		String sort = ObjectUtil.toString(params.get("sort"));
		String order = ObjectUtil.toString(params.get("order"));

		Map<String,Object> reqParam = new HashMap<>();
		if (StrUtil.isNotEmpty(roleIds)){
			reqParam.put("roleIds",roleIds);
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

		Map<String,Object> result = roleService.getRoleListMap(reqParam);
		Integer total = ObjectUtil.toInteger(result.get("total"));
		List<SysRole> sysRoleList = (List<SysRole>)result.get("list");

		Map<String,Object> resultMap= ResultGenerator.getSuccessMap();
		resultMap.put("total", total);
		resultMap.put("rows", sysRoleList);
		return resultMap;
	}

	@GetMapping("/getRoleDetail")
	@ResponseBody
	public Map<String,Object> getRoleDetail(Long id) {
		SysRole sysRole = roleService.getRoleDetail(id);

		if (ObjectUtil.isNull(sysRole)){
			return ResultGenerator.getFailMap(ResultCode.CODE_FAIL.getCode(),"数据为空！");
		}

		Map<String,Object> result = ResultGenerator.getSuccessMap();
		result.put("data", sysRole);
		return result;
	}

	@PostMapping("/saveRole")
	@ResponseBody
	public Map<String,Object> saveRole(SysRole sysRole) {
		String errMsg= roleService.saveRole(sysRole);
		if (StrUtil.isNotEmpty(errMsg)){
			return ResultGenerator.getFailMap(ResultCode.CODE_FAIL.getCode(),errMsg);
		}

		return ResultGenerator.getSuccessMap();
	}

}
