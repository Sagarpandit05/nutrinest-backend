package com.nutrinest.backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String productId;

    private String productName;

    @Column(length = 1000)
    private String description;

    private double price;

    private double originalPrice;

    private int stockQuantity;

    private String imageUrl;

    private LocalDateTime createdAt;

    private boolean isActive = true;

    // 🔥 Many Products → One Category
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}