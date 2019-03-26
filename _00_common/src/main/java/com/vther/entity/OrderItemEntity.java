package com.vther.entity;

import lombok.Data;

@Data
public class OrderItemEntity {
    private int id;
    private String orderItemId;
    private String orderId;
    private String customerId;
    private String customerName;
    private String productId;
    private String productName;
    private String createTime;
    private String currency;
}
