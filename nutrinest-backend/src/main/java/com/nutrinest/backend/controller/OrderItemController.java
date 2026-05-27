package com.nutrinest.backend.controller;

import com.nutrinest.backend.model.OrderItem;
import com.nutrinest.backend.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order-items")
@RequiredArgsConstructor
public class OrderItemController {

    private final OrderItemService service;

    @PostMapping
    public OrderItem create(
            @RequestParam String orderId,
            @RequestParam String productId,
            @RequestParam int quantity,
            @RequestParam double price) {

        return service.create(orderId, productId, quantity, price);
    }
}
