package com.nutrinest.backend.repository;

import com.nutrinest.backend.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, String> {


}