package com.nutrinest.backend.service.impl;

import com.nutrinest.backend.model.Cart;
import com.nutrinest.backend.model.CartItem;
import com.nutrinest.backend.model.Product;
import com.nutrinest.backend.repository.CartItemRepository;
import com.nutrinest.backend.repository.CartRepository;
import com.nutrinest.backend.repository.ProductRepository;
import com.nutrinest.backend.service.CartItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartItemServiceImpl implements CartItemService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final CartItemRepository cartItemRepository;

    @Override
    public CartItem addItem(String cartId, String productId, int quantity) {

        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        CartItem item = new CartItem();
        item.setCart(cart);
        item.setProduct(product);
        item.setQuantity(quantity);
        item.setPrice(product.getPrice());

        return cartItemRepository.save(item);
    }

    @Override
    public List<CartItem> getCartItems(String cartId) {
        return cartItemRepository.findAll()
                .stream()
                .filter(i -> i.getCart().getCartId().equals(cartId))
                .toList();
    }

    @Override
    public void deleteItem(String cartItemId) {
        cartItemRepository.deleteById(cartItemId);
    }
}