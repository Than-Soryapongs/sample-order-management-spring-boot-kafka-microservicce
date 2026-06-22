package com.sample.order_service.model;

import java.time.LocalDateTime;

public class Order {
    private long id;
    private String productId;
    private int quantity;
    private String status;
    private LocalDateTime createdAt;

    public long getId() { return id;}
    public void setId(long id) { this.id = id;}

    public String getProductId() { return productId;}
    public void setProductId(String productId) { this.productId = productId;}

    public int getQuantity() { return quantity;}
    public void setQuantity(int quantity) { this.quantity = quantity;}

    public String getStatus() { return status;}
    public void setStatus(String status) { this.status = status;}

    public LocalDateTime getCreatedAt() { return createdAt;}
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

}
