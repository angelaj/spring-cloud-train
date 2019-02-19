package com.train.feign.hystrix;

import com.train.common.constant.ResultCode;
import com.train.common.utils.ResultGenerator;
import com.train.feign.SupplierFeignClient;
import com.train.model.Supplier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Map;

@Component
public class SupplierFeignClientHystrix implements SupplierFeignClient {
    @Override
    public Map<String, Object> getSupplierList(Map<String, Object> param) {
        Map<String,Object> result = ResultGenerator.getFailMap(ResultCode.CODE_FAIL.getCode(),"调用接口失败！");
        result.put("total",0);
        result.put("list",new ArrayList<Supplier>());
        return result;
    }

    @Override
    public Map<String, Object> getBySupplierId(Long supplierId) {
        Map<String,Object> result = ResultGenerator.getFailMap(ResultCode.CODE_FAIL.getCode(),"调用接口失败！");
        result.put("data",null);
        return result;
    }

    @Override
    public Map<String, Object> saveSupplier(Supplier supplier) {
        Map<String,Object> result = ResultGenerator.getFailMap(ResultCode.CODE_FAIL.getCode(),"调用接口失败！");
        return result;
    }
}
