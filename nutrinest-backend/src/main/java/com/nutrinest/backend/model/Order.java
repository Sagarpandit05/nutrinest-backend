package com.nutrinest.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String orderId;

    @ManyToOne
    @JoinColumn(name = "user_id")

    @JsonIgnoreProperties({
            "addresses",
            "orders",
            "passwordHash"
    })

    private User user;

    @ManyToOne
    @JoinColumn(name = "address_id")

    @JsonIgnoreProperties({
            "user"
    })

    private Address address;

    private double totalAmount;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    private LocalDateTime createdAt;
    @JsonManagedReference
    @OneToMany(
            mappedBy = "order",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<OrderItem> items;
}