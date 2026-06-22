package com.sample.notification_service.service;

import org.springframework.stereotype.Service;

import com.sample.notification_service.model.OrderEvent;

@Service
public class NotificationService {
    public void sendOrderConfirmation(OrderEvent event) {
        // In real project: integrate SMTP email or SMS here
        System.out.println("==========================================");
        System.out.println("[Notification] Order Confirmation");
        System.out.println("  Order ID  : " + event.getOrderId());
        System.out.println("  Product   : " + event.getProductId());
        System.out.println("  Quantity  : " + event.getQuantity());
        System.out.println("  Status    : " + event.getStatus());
        System.out.println("  Message   : Your order has been placed!");
        System.out.println("==========================================");
    }
}
