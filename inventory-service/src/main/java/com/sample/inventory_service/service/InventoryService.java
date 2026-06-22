package com.sample.inventory_service.service;

import org.springframework.stereotype.Service;

import com.sample.inventory_service.mapper.InventoryMapper;
import com.sample.inventory_service.model.Inventory;

@Service
public class InventoryService {
    private final InventoryMapper inventoryMapper;

    public InventoryService(InventoryMapper inventoryMapper) {
        this.inventoryMapper = inventoryMapper;
    }

    public Inventory getStock(String productId) {
        return inventoryMapper.findByProductId(productId);
    }

    public boolean deductStock(String productId, int quantity) {
        Inventory inventory = inventoryMapper.findByProductId(productId);

        if (inventory == null) {
            System.out.println("[Inventory] Product not found: " + productId);
            return false;
        }

        if (inventory.getQuantity() < quantity) {
            System.out.println("[Inventory] Insufficient stock for: " + productId
                + " | available: " + inventory.getQuantity()
                + " | requested: " + quantity);
            return false;
        }

        inventoryMapper.deductStock(productId, quantity);
        System.out.println("[Inventory] Stock deducted for: " + productId
            + " | deducted: " + quantity
            + " | remaining: " + (inventory.getQuantity() - quantity));
        return true;
    }
}
