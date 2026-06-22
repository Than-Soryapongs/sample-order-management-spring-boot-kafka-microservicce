package com.sample.inventory_service.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.sample.inventory_service.model.Inventory;

@Mapper
public interface InventoryMapper {
    Inventory findByProductId(String productId);
    void deductStock(String productId, int quantity);
}
