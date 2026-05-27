package com.nutrinest.backend.service.impl;

import com.nutrinest.backend.model.Order;
import com.nutrinest.backend.model.OrderItem;
import com.nutrinest.backend.model.Product;
import com.nutrinest.backend.repository.OrderItemRepository;
import com.nutrinest.backend.repository.OrderRepository;
import com.nutrinest.backend.repository.ProductRepository;
import com.nutrinest.backend.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final OrderItemRepository orderItemRepository;

    @Override
    public OrderItem create(String orderId, String productId, int quantity, double price) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        OrderItem item = new OrderItem();
        item.setOrder(order);
        item.setProduct(product);
        item.setQuantity(quantity);
        item.setPrice(price);

        return orderItemRepository.save(item);
    }
}
