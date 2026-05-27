package com.nutrinest.backend.service;

import com.nutrinest.backend.model.Cart;

import java.util.List;

public interface CartService {
    Cart createCart(String userId);
    Cart getCart(String cartId);
    List<Cart> getAll();
    void deleteCart(String cartId);
}