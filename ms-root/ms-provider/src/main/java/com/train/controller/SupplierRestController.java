package com.train.controller;

import com.train.common.constant.ResultCode;
import com.train.common.util.ObjectUtil;
import com.train.common.util.StrUtil;
import com.train.common.utils.ResultGenerator;
import com.train.model.Supplier;
import com.train.service.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/supplier")
public class SupplierRestController {
    @Autowired
    ISupplierService supplierService;

    @RequestMapping(value = "/getSupplierList", method = RequestMethod.POST)
    @ResponseBody
    Map<String,Object> getSupplierList(@RequestBody Map<String, Object> param){
        String supplierIds = ObjectUtil.toString(param.get("supplierIds"));
        String supplierName = ObjectUtil.toString(param.get("supplierName"));
        Integer start = ObjectUtil.toInteger(param.get("start"));
        Integer limit = ObjectUtil.toInteger(param.get("limit"));

        Map<String,Object> result = ResultGenerator.getSuccessMap();
        Map<String, Object> reqParam = new HashMap<>();
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

        Integer total = supplierService.getSupplierCount(reqParam);
        List<Supplier> supplierList = new ArrayList<>();
        if (total>0){
            supplierList = supplierService.getSupplierList(param);
        }
        result.put("total",total);
        result.put("list",supplierList);
        return result;
    }

    @RequestMapping(value = "/getBySupplierId", method = RequestMethod.GET)
    @ResponseBody
    Map<String,Object> getBySupplierId(@RequestParam("supplierId") Long supplierId){
        Map<String,Object> result = ResultGenerator.getSuccessMap();
        Supplier supplier = supplierService.getSupplierDetail(supplierId);
        if (supplier ==null){
            result = ResultGenerator.getFailMap(ResultCode.CODE_FAIL.getCode(),"数据为空！");
        }
        result.put("data",supplier);
        return result;
    }

    @RequestMapping(value = "/saveSupplier", method = RequestMethod.POST)
    @ResponseBody
    Map<String,Object> saveSupplier(@RequestBody Supplier supplier){
        Map<String,Object> result = ResultGenerator.getSuccessMap();
        String errMsg = supplierService.saveSupplier(supplier);
        if (StrUtil.isNotEmpty(errMsg)){
            result = ResultGenerator.getFailMap(ResultCode.CODE_FAIL.getCode(), errMsg);
        }
        return result;
    }
}
