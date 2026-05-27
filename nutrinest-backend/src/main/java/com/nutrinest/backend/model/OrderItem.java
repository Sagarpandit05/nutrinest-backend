package com.nutrinest.backend.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

@Entity
@Data
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String orderItemId;

    // 🔥 Many items → One Order
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    // 🔥 Many items → One Product
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private int quantity;

    private double price; // snapshot price
}