package com.nutrinest.backend.service;
import com.nutrinest.backend.model.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(String userId, String addressId, double totalAmount);
    List<Order> getAll();
    Order getById(String id);
    void delete(String id);
    List<Order> getOrdersByUser(String userId);
    Order updateStatus(String id, String status);
}