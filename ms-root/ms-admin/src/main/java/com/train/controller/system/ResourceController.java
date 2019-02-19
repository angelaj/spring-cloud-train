package com.train.controller.system;

import com.train.common.constant.ResultCode;
import com.train.common.util.ObjectUtil;
import com.train.common.util.StrUtil;
import com.train.common.utils.ResultGenerator;
import com.train.model.SysResource;
import com.train.service.IResourceService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/system/resource")
public class ResourceController {

	@Autowired
	private IResourceService resourceService;

	@GetMapping("/manager")
	public String manager() {
		return "system/resource";
	}

	@GetMapping("/getResourceList")
	@ResponseBody
	public Map<String,Object> getResourceList(@RequestParam Map<String, Object> params) {
		String resourceIds = ObjectUtil.toString(params.get("resourceIds"));
		String resourceName = ObjectUtil.toString(params.get("resourceName"));
		Integer resourceType = ObjectUtil.toInteger(params.get("resourceType"));
		Long parentId = ObjectUtil.toLong(params.get("parentId"));
		Integer start = ObjectUtil.toInteger(params.get("start"));
		Integer limit = ObjectUtil.toInteger(params.get("limit"));
		String sort = ObjectUtil.toString(params.get("sort"));
		String order = ObjectUtil.toString(params.get("order"));

		Map<String,Object> reqParam = new HashMap<>();
		if (StrUtil.isNotEmpty(resourceIds)){
			reqParam.put("resourceIdAry",resourceIds.split(","));
		}
		if (StrUtil.isNotEmpty(resourceName)){
			reqParam.put("resourceName",resourceName);
		}
		if (ObjectUtil.isNotNull(resourceType)){
			reqParam.put("resourceType",resourceType);
		}
		if (ObjectUtil.isNotNull(parentId)){
			reqParam.put("parentId",parentId);
		}
		if (ObjectUtil.isNotNull(start) && ObjectUtil.isNotNull(limit)){
			reqParam.put("start",start);
			reqParam.put("limit",limit);
		}
		if (StringUtils.isNotEmpty(sort) && StringUtils.isNotEmpty(order)){
			reqParam.put("sort",sort);
			reqParam.put("order",order);
		}

		Map<String,Object> result = resourceService.getResourceListMap(reqParam);
		Integer total = ObjectUtil.toInteger(result.get("total"));
		List<SysResource> sysResourceList = (List<SysResource>)result.get("list");

		Map<String,Object> resultMap= ResultGenerator.getSuccessMap();
		resultMap.put("total", total);
		resultMap.put("rows", sysResourceList);
		return resultMap;
	}

	@GetMapping("/getResourceDetail")
	@ResponseBody
	public Map<String,Object> getResourceDetail(Long id) {
		SysResource sysResource = resourceService.getResourceDetail(id);

		if (ObjectUtil.isNull(sysResource)){
			return ResultGenerator.getFailMap(ResultCode.CODE_FAIL.getCode(),"数据为空！");
		}

		Map<String,Object> result = ResultGenerator.getSuccessMap();
		result.put("data", sysResource);
		return result;
	}

	@PostMapping("/saveResource")
	@ResponseBody
	public Map<String,Object> saveResource(SysResource sysResource) {
		String errMsg= resourceService.saveResource(sysResource);
		if (StringUtils.isNotEmpty(errMsg)){
			return ResultGenerator.getFailMap(ResultCode.CODE_FAIL.getCode(),errMsg);
		}

		return ResultGenerator.getSuccessMap();
	}

	@GetMapping("/getSysResourceTree")
	@ResponseBody
	public Map<String,Object> getSysResourceTree(){
		List<SysResource> resourceListTree = resourceService.getAllResourceList();
		Map<String,Object> result = ResultGenerator.getSuccessMap();
		result.put("data",resourceListTree);
		return result;
	}
}
