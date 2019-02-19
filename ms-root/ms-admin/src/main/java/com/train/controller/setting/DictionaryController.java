package com.train.controller.setting;

import com.train.common.constant.ResultCode;
import com.train.common.util.ObjectUtil;
import com.train.common.util.StrUtil;
import com.train.common.utils.ResultGenerator;
import com.train.model.Dictionary;
import com.train.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/setting/dictionary")
public class DictionaryController {

	@Autowired
	private IDictionaryService dictionaryService;

	@GetMapping("/manager")
	public String manager() {
		return "setting/dictionary";
	}

	@GetMapping("/getDicCodeList")
	@ResponseBody
	public Map<String,Object> getDicCodeList(@RequestParam Map<String, Object> params) {
		String dicCodes = ObjectUtil.toString(params.get("dicCodes"));
		Integer start = ObjectUtil.toInteger(params.get("start"));
		Integer limit = ObjectUtil.toInteger(params.get("limit"));
		String sort = ObjectUtil.toString(params.get("sort"));
		String order = ObjectUtil.toString(params.get("order"));

		Map<String,Object> reqParam = new HashMap<>();
		if (StrUtil.isNotEmpty(dicCodes)){
			reqParam.put("dicCodeAry",dicCodes.split(","));
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
		List<String> dicCodeList = new ArrayList<>();
		Map<String,Object> result = dictionaryService.getDicCodeMap(reqParam);
		total = ObjectUtil.toInteger(result.get("total"));
		dicCodeList= (List<String>) result.get("list");

		Map<String,Object> resultMap = ResultGenerator.getSuccessMap();
		resultMap.put("total", total);
		resultMap.put("rows", dicCodeList);
		return resultMap;
	}

	@GetMapping("/getDictionaryList")
	@ResponseBody
	public Map<String,Object> getDictionaryList(@RequestParam Map<String, Object> params) {
		String dicCode = ObjectUtil.toString(params.get("dicCode"));
		String dictionaryIds = ObjectUtil.toString(params.get("dictionaryIds"));
		String itemName = ObjectUtil.toString(params.get("itemName"));
		Integer itemValue = ObjectUtil.toInteger(params.get("itemValue"));
		Integer start = ObjectUtil.toInteger(params.get("start"));
		Integer limit = ObjectUtil.toInteger(params.get("limit"));
		String sort = ObjectUtil.toString(params.get("sort"));
		String order = ObjectUtil.toString(params.get("order"));

		Map<String,Object> reqParam = new HashMap<>();
		if (StrUtil.isNotEmpty(dicCode)){
			reqParam.put("dicCode",dicCode);
		}
		if (StrUtil.isNotEmpty(dictionaryIds)){
			reqParam.put("dictionaryIdAry",dictionaryIds.split(","));
		}
		if (StrUtil.isNotEmpty(itemName)){
			reqParam.put("itemName",itemName);
		}
		if (ObjectUtil.isNotNull(itemValue)){
			reqParam.put("itemValue",itemValue);
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
		List<Dictionary> dictionaryList = new ArrayList<>();
		Map<String,Object> result = dictionaryService.getDictionaryMap(reqParam);
		total = ObjectUtil.toInteger(result.get("total"));
		dictionaryList= (List<Dictionary>) result.get("list");

		Map<String,Object> resultMap= ResultGenerator.getSuccessMap();
		resultMap.put("total", total);
		resultMap.put("rows", dictionaryList);
		return resultMap;
	}

	@GetMapping("/getDictionaryDetail")
	@ResponseBody
	public Map<String,Object> getDictionaryDetail(Long id) {
		Dictionary dictionary = dictionaryService.getDictionaryDetail(id);

		if (ObjectUtil.isNull(dictionary)){
			return ResultGenerator.getFailMap(ResultCode.CODE_FAIL.getCode(),"数据为空！");
		}

		Map<String,Object> result = ResultGenerator.getSuccessMap();
		result.put("data", dictionary);
		return result;
	}

	@PostMapping("/saveDictionary")
	@ResponseBody
	public Map<String,Object> saveDictionary(Dictionary dictionary) {
		String errMsg= dictionaryService.saveDictionary(dictionary);
		if (StrUtil.isNotEmpty(errMsg)){
			return ResultGenerator.getFailMap(ResultCode.CODE_FAIL.getCode(),errMsg);
		}

		return ResultGenerator.getSuccessMap();
	}
}
