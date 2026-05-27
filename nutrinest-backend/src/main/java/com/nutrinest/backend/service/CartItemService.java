package com.nutrinest.backend.service;
import com.nutrinest.backend.model.CartItem;

import java.util.List;

public interface CartItemService {
    CartItem addItem(String cartId, String productId, int quantity);
    List<CartItem> getCartItems(String cartId);
    void deleteItem(String cartItemId);
}
