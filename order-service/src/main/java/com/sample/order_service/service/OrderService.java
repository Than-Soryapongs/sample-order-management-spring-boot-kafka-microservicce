package com.sample.order_service.service;

import org.springframework.stereotype.Service;

import com.sample.order_service.kafka.OrderEventProducer;
import com.sample.order_service.mapper.OrderMapper;
import com.sample.order_service.model.Order;
import com.sample.order_service.model.OrderEvent;

@Service
public class OrderService {

    private final OrderMapper orderMapper;
    private final OrderEventProducer producer;

    public OrderService(OrderMapper orderMapper, OrderEventProducer producer) {
        this.orderMapper = orderMapper;
        this.producer = producer;
    }

    public Order createOrder(Order order) {
        // 1. Set initial status
        order.setStatus("PENDING");

        // 2. Save to DB
        orderMapper.insert(order);

        // 3. Build Kafka event
        OrderEvent event = new OrderEvent();
        event.setOrderId(order.getId());
        event.setProductId(order.getProductId());
        event.setQuantity(order.getQuantity());
        event.setStatus(order.getStatus());

        // 4. Publish event
        producer.publishOrderCreated(event);

        return order;
    }

    public Order getOrderById(Long id) {
        return orderMapper.findById(id);
    }
}
