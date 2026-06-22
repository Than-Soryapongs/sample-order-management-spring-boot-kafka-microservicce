package com.sample.inventory_service.kafka;

import com.sample.inventory_service.model.OrderEvent;
import com.sample.inventory_service.service.InventoryService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class InventoryEventConsumer {

    private final InventoryService inventoryService;

    public InventoryEventConsumer(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @KafkaListener(topics = "order-created", groupId = "inventory-group")
    public void handleOrderCreated(OrderEvent event) {
        System.out.println("[Inventory] Received event for orderId: " + event.getOrderId()
            + " | product: " + event.getProductId()
            + " | qty: " + event.getQuantity());

        boolean success = inventoryService.deductStock(
            event.getProductId(),
            event.getQuantity()
        );

        if (success) {
            System.out.println("[Inventory] Stock reserved successfully for orderId: "
                + event.getOrderId());
        } else {
            System.out.println("[Inventory] Failed to reserve stock for orderId: "
                + event.getOrderId());
        }
    }
}