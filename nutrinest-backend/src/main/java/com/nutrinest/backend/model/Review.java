package com.nutrinest.backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String reviewId;

    // 🔥 Many reviews → One User
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // 🔥 Many reviews → One Product
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private int rating; // 1 to 5

    @Column(length = 1000)
    private String comment;

    private LocalDateTime createdAt;
}
