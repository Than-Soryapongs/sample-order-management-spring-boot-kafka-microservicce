package com.sample.order_service.mapper;

import com.sample.order_service.model.Order;

public interface OrderMapper {
    void insert(Order order);
    Order findById(long id);
}
