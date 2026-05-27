package com.nutrinest.backend.controller;

import com.nutrinest.backend.model.Payment;
import com.nutrinest.backend.model.PaymentMethod;
import com.nutrinest.backend.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService service;

    @PostMapping
    public Payment create(
            @RequestParam String orderId,
            @RequestParam PaymentMethod method) {

        return service.create(orderId, method);
    }
}
