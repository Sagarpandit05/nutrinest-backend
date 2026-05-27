package com.nutrinest.backend.service.impl;

import com.nutrinest.backend.model.Address;
import com.nutrinest.backend.model.Order;
import com.nutrinest.backend.model.OrderStatus;
import com.nutrinest.backend.model.User;
import com.nutrinest.backend.repository.AddressRepository;
import com.nutrinest.backend.repository.OrderRepository;
import com.nutrinest.backend.repository.UserRepository;
import com.nutrinest.backend.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    @Override
    public Order createOrder(String userId, String addressId, double totalAmount) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Address address = addressRepository.findById(addressId)
                .orElseThrow(() -> new RuntimeException("Address not found"));

        Order order = new Order();
        order.setUser(user);
        order.setAddress(address);
        order.setTotalAmount(totalAmount);
        order.setOrderStatus(OrderStatus.PENDING);
        order.setCreatedAt(LocalDateTime.now());

        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

//    @Override
//    public Order getById(String id) {
//        return orderRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Order not found"));
//    }
@Override
public Order getById(String id) {

    Order order = orderRepository.findById(id)
            .orElseThrow(() ->
                    new RuntimeException("Order not found"));

    return order;
}
    @Override
    public List<Order> getOrdersByUser(String userId) {

        return orderRepository.findByUser_Id(userId);

    }

    @Override
    public void delete(String id) {
        orderRepository.deleteById(id);
    }
    @Override
    public Order updateStatus(String id, String status) {

        Order order = orderRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Order not found"));

        order.setOrderStatus(
                OrderStatus.valueOf(status)
        );

        return orderRepository.save(order);
    }
}