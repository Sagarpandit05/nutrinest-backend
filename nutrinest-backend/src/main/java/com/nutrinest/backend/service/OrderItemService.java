package com.nutrinest.backend.service;

import com.nutrinest.backend.model.OrderItem;

public interface OrderItemService {
    OrderItem create(String orderId, String productId, int quantity, double price);
}