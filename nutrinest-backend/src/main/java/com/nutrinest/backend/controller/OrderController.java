package com.nutrinest.backend.controller;

import com.nutrinest.backend.model.Order;
import com.nutrinest.backend.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
@CrossOrigin("*")
public class OrderController {

    private final OrderService orderService;

//    @PostMapping
//    public Order create(
//            @RequestParam String userId,
//            @RequestParam String addressId,
//            @RequestParam double totalAmount) {
//
//        return orderService.createOrder(userId, addressId, totalAmount);
//    }
@PostMapping
public Map<String, Object> create(
        @RequestParam String userId,
        @RequestParam String addressId,
        @RequestParam double totalAmount) {

    Order order = orderService.createOrder(userId, addressId, totalAmount);

    Map<String, Object> response = new HashMap<>();

    response.put("orderId", order.getOrderId());
    response.put("message", "Order created successfully");

    return response;
}

    @GetMapping
    public List<Order> getAll() {
        return orderService.getAll();
    }

    @GetMapping("/{id}")
    public Order get(@PathVariable String id) {
        return orderService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        orderService.delete(id);
    }

    @GetMapping("/user/{userId}")
    public List<Order> getUserOrders(
            @PathVariable String userId
    ) {

        return orderService.getOrdersByUser(userId);

    }

    @PutMapping("/{id}/status")
    public Order updateStatus(
            @PathVariable String id,
            @RequestParam String status
    ) {
        return orderService.updateStatus(id, status);
    }
}