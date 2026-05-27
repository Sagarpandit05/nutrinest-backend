package com.nutrinest.backend.service;

import com.nutrinest.backend.model.Payment;
import com.nutrinest.backend.model.PaymentMethod;

public interface PaymentService {
    Payment create(String orderId, PaymentMethod method);
}
