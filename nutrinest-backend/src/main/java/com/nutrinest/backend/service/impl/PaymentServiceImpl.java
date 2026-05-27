package com.nutrinest.backend.service.impl;

import com.nutrinest.backend.model.Order;
import com.nutrinest.backend.model.Payment;
import com.nutrinest.backend.model.PaymentMethod;
import com.nutrinest.backend.model.PaymentStatus;
import com.nutrinest.backend.repository.OrderRepository;
import com.nutrinest.backend.repository.PaymentRepository;
import com.nutrinest.backend.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final OrderRepository orderRepository;
    private final PaymentRepository paymentRepository;

    @Override
    public Payment create(String orderId, PaymentMethod method) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        Payment payment = new Payment();
        payment.setOrder(order);
        payment.setPaymentMethod(method);
        payment.setPaymentStatus(PaymentStatus.PENDING);
        payment.setCreatedAt(LocalDateTime.now());

        return paymentRepository.save(payment);
    }
}