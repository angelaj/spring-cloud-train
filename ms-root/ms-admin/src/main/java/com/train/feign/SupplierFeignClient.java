package com.train.feign;

import com.train.feign.hystrix.SupplierFeignClientHystrix;
import com.train.model.Supplier;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(value = "${app.provider}",fallback = SupplierFeignClientHystrix.class)
public interface SupplierFeignClient {
    @RequestMapping(value = "/api/supplier/getSupplierList", method = RequestMethod.POST)
    Map<String,Object> getSupplierList(@RequestBody Map<String, Object> param);

    @RequestMapping(value = "/api/supplier/getBySupplierId", method = RequestMethod.GET)
    Map<String,Object> getBySupplierId(@RequestParam("supplierId") Long supplierId);

    @RequestMapping(value = "/api/supplier/saveSupplier", method = RequestMethod.POST)
    Map<String,Object> saveSupplier(@RequestBody Supplier supplier);
}
