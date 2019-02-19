package com.train.service;

import com.train.model.Supplier;

import java.util.Map;

public interface ISupplierService {
    Map<String,Object> getSupplierMap(Map<String, Object> param);

    Supplier getSupplierDetail(Long supplierId);

    String saveSupplier(Supplier supplier);
}
