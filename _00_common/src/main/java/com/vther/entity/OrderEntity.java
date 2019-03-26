package com.vther.entity;

import lombok.Data;

@Data
public class OrderEntity {
    private int id;
    private String orderId;
    private String customerId;
    private String customerName;
    private Integer status;
    private String createTime;
    private String currency;
}
