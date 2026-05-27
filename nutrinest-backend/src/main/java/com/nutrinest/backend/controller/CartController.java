package com.nutrinest.backend.controller;

import com.nutrinest.backend.model.Cart;
import com.nutrinest.backend.service.impl.CartServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CartController {

    private final CartServiceImpl cartService;

    @PostMapping("/{userId}")
    public Cart create(@PathVariable String userId) {
        return cartService.createCart(userId);
    }

    @GetMapping("/{cartId}")
    public Cart get(@PathVariable String cartId) {
        return cartService.getCart(cartId);
    }

    @GetMapping
    public List<Cart> getAll() {
        return cartService.getAll();
    }

    @DeleteMapping("/{cartId}")
    public void delete(@PathVariable String cartId) {
        cartService.deleteCart(cartId);
    }
}