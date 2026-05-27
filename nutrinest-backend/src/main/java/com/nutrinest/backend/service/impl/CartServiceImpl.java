package com.nutrinest.backend.service.impl;

import com.nutrinest.backend.model.Cart;
import com.nutrinest.backend.model.User;
import com.nutrinest.backend.repository.CartRepository;
import com.nutrinest.backend.repository.UserRepository;
import com.nutrinest.backend.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final UserRepository userRepository;

    @Override
    public Cart createCart(String userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Cart cart = new Cart();
        cart.setUser(user);
        cart.setCreatedAt(LocalDateTime.now());

        return cartRepository.save(cart);
    }

    @Override
    public Cart getCart(String cartId) {
        return cartRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Cart not found"));
    }

    @Override
    public List<Cart> getAll() {
        return cartRepository.findAll();
    }

    @Override
    public void deleteCart(String cartId) {
        cartRepository.deleteById(cartId);
    }
}
