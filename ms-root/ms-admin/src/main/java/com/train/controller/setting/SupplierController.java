package com.train.controller.setting;

import com.train.common.constant.ResultCode;
import com.train.common.util.ObjectUtil;
import com.train.common.util.StrUtil;
import com.train.common.utils.ResultGenerator;
import com.train.model.Supplier;
import com.train.service.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/setting/supplier")
public class SupplierController {

	@Autowired
	private ISupplierService supplierService;

	@GetMapping("/manager")
	public String manager() {
		return "setting/supplier";
	}

	@GetMapping("/getSupplierList")
	@ResponseBody
	public Map<String,Object> getSupplierList(@RequestParam Map<String, Object> params) {
		String supplierIds = ObjectUtil.toString(params.get("supplierIds"));
		String supplierName = ObjectUtil.toString(params.get("supplierName"));
		Integer start = ObjectUtil.toInteger(params.get("start"));
		Integer limit = ObjectUtil.toInteger(params.get("limit"));
		String sort = ObjectUtil.toString(params.get("sort"));
		String order = ObjectUtil.toString(params.get("order"));

		Map<String,Object> reqParam = new HashMap<>();
		if (StrUtil.isNotEmpty(supplierIds)){
			reqParam.put("supplierIdAry",supplierIds.split(","));
		}
		if (StrUtil.isNotEmpty(supplierName)){
			reqParam.put("supplierName",supplierName);
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
		List<Supplier> supplierList = new ArrayList<>();
		Map<String,Object> result = supplierService.getSupplierMap(reqParam);
		total = ObjectUtil.toInteger(result.get("total"));
		supplierList= (List<Supplier>) result.get("list");

		Map<String,Object> resultMap= ResultGenerator.getSuccessMap();
		resultMap.put("total", total);
		resultMap.put("rows", supplierList);
		return resultMap;
	}

	@GetMapping("/getSupplierDetail")
	@ResponseBody
	public Map<String,Object> getSupplierDetail(Long id) {
		Supplier supplier = supplierService.getSupplierDetail(id);

		if (ObjectUtil.isNull(supplier)){
			return ResultGenerator.getFailMap(ResultCode.CODE_FAIL.getCode(),"数据为空！");
		}

		Map<String,Object> result = ResultGenerator.getSuccessMap();
		result.put("data", supplier);
		return result;
	}

	@PostMapping("/saveSupplier")
	@ResponseBody
	public Map<String,Object> saveSupplier(Supplier supplier) {
		String errMsg= supplierService.saveSupplier(supplier);
		if (StrUtil.isNotEmpty(errMsg)){
			return ResultGenerator.getFailMap(ResultCode.CODE_FAIL.getCode(),errMsg);
		}

		return ResultGenerator.getSuccessMap();
	}
}
