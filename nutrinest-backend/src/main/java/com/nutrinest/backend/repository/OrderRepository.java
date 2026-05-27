package com.nutrinest.backend.repository;

import com.nutrinest.backend.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, String> {
    List<Order> findByUser_Id(String userId);
}