package com.train.mapper;

import com.train.model.Supplier;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface SupplierMapper {
    Integer getSupplierCount(Map<String, Object> param);

    List<Supplier> getSupplierList(Map<String, Object> param);

    Supplier getById(@Param("id") Long id);

    Integer insertSupplier(Supplier supplier);

    Integer updateSupplier(Supplier supplier);
}