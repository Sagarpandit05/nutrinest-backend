package com.nutrinest.backend.controller;

import com.nutrinest.backend.model.CartItem;
import com.nutrinest.backend.service.CartItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart-items")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CartItemController {

    private final CartItemService cartItemService;

    @PostMapping
    public CartItem addItem(
            @RequestParam String cartId,
            @RequestParam String productId,
            @RequestParam int quantity) {

        return cartItemService.addItem(cartId, productId, quantity);
    }

    @GetMapping("/{cartId}")
    public List<CartItem> getItems(@PathVariable String cartId) {
        return cartItemService.getCartItems(cartId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        cartItemService.deleteItem(id);
    }
}