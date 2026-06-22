package com.sample.notification_service.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.sample.notification_service.model.OrderEvent;
import com.sample.notification_service.service.NotificationService;

@Service
public class NotificationEventConsumer {
    private final NotificationService notificationService;

    public NotificationEventConsumer(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @KafkaListener(topics = "order-created", groupId = "notification-group")
    public void handleOrderCreated(OrderEvent event) {
        System.out.println("[Notification] Received event for orderId: "
            + event.getOrderId());
        notificationService.sendOrderConfirmation(event);
    }
}
