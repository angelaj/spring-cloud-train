package com.train.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.train.common.constant.ResultCode;
import com.train.common.util.ObjectUtil;
import com.train.feign.SupplierFeignClient;
import com.train.model.Supplier;
import com.train.service.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SupplierServiceImpl implements ISupplierService {
    @Autowired
    SupplierFeignClient supplierFeignClient;

    @Override
    public Map<String,Object> getSupplierMap(Map<String, Object> param) {
        Map<String,Object> result = new HashMap<>();
        Integer total = 0;
        List<Supplier> supplierList = new ArrayList<>();

        Map<String,Object> resultMap = supplierFeignClient.getSupplierList(param);
        if (resultMap!=null && resultMap.get("rsCode").equals(ResultCode.CODE_SUCCESS.getCode())){
            total = ObjectUtil.toInteger(resultMap.get("total"));
            Object listObj = resultMap.get("list");
            String listObjStr = JSONObject.toJSONString(listObj);
            supplierList= JSONObject.parseArray(listObjStr, Supplier.class);
        }

        result.put("total",total);
        result.put("list",supplierList);
        return result;
    }

    @Override
    public Supplier getSupplierDetail(Long supplierId) {
        Map<String,Object> resultMap = supplierFeignClient.getBySupplierId(supplierId);
        if (resultMap!=null && resultMap.get("rsCode").equals(ResultCode.CODE_SUCCESS.getCode())) {
            Object dataObj = resultMap.get("data");
            String dataStr = JSONObject.toJSONString(dataObj);
            Supplier supplier = JSONObject.parseObject(dataStr, Supplier.class);
            return supplier;
        }

        return null;
    }

    @Override
    public String saveSupplier(Supplier supplier) {
        String errMsg = "";
        Map<String,Object> resultMap = supplierFeignClient.saveSupplier(supplier);
        if (resultMap==null){
            errMsg += "返回结果为空！";
        }else if(!resultMap.get("rsCode").equals(ResultCode.CODE_SUCCESS.getCode())){
            errMsg += resultMap.get("rsMsg");
        }

        return errMsg;
    }
}
