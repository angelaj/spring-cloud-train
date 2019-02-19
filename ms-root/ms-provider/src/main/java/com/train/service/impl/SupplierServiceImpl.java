package com.train.service.impl;

import com.train.mapper.SupplierMapper;
import com.train.model.Supplier;
import com.train.service.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class SupplierServiceImpl implements ISupplierService {
    @Autowired
    SupplierMapper supplierMapper;

    @Override
    public Integer getSupplierCount(Map<String, Object> param) {
        return supplierMapper.getSupplierCount(param);
    }

    @Override
    public List<Supplier> getSupplierList(Map<String, Object> param) {
        return supplierMapper.getSupplierList(param);
    }

    @Override
    public Supplier getSupplierDetail(Long dictinaryId) {
        return supplierMapper.getById(dictinaryId);
    }

    @Transactional
    @Override
    public String saveSupplier(Supplier supplier) {
        Long supplierId = supplier.getId();
        //新增或更新用户信息
        if (supplierId == null){//新增
            supplier.setCreateTime(new Date());
            supplier.setUpdateTime(new Date());
            supplierMapper.insertSupplier(supplier);
        }else {
            supplier.setUpdateTime(new Date());
            supplierMapper.updateSupplier(supplier);
        }

        return "";
    }
}
