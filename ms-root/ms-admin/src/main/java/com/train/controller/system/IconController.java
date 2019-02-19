package com.train.controller.system;

import com.train.common.util.ObjectUtil;
import com.train.common.util.StrUtil;
import com.train.common.utils.ResultGenerator;
import com.train.model.Icon;
import com.train.service.IIconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/system/icon")
public class IconController {

	@Autowired
	private IIconService iconService;

	@GetMapping("/getIconList")
	@ResponseBody
	public Map<String,Object> getIconList(@RequestParam Map<String, Object> params) {
		String iconName = ObjectUtil.toString(params.get("iconName"));
		Integer start = ObjectUtil.toInteger(params.get("start"));
		Integer limit = ObjectUtil.toInteger(params.get("limit"));

		Map<String,Object> reqParam = new HashMap<>();
		if (StrUtil.isNotEmpty(iconName)){
			reqParam.put("iconName",iconName);
		}
		if (ObjectUtil.isNotNull(start) && ObjectUtil.isNotNull(limit)){
			reqParam.put("start",start);
			reqParam.put("limit",limit);
		}

		Map<String,Object> result = iconService.getIconMap(reqParam);
		Integer total = ObjectUtil.toInteger(result.get("total"));
		List<Icon> iconList = (List<Icon>)result.get("list");

		Map<String,Object> resultMap= ResultGenerator.getSuccessMap();
		resultMap.put("total", total);
		resultMap.put("rows", iconList);
		return resultMap;
	}
}
