package com.train.service;

import com.train.model.Supplier;

import java.util.List;
import java.util.Map;

public interface ISupplierService {
    Integer getSupplierCount(Map<String, Object> param);

    List<Supplier> getSupplierList(Map<String, Object> param);

    Supplier getSupplierDetail(Long supplierId);

    String saveSupplier(Supplier supplier);
}
