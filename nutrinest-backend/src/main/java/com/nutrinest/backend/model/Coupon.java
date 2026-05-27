package com.nutrinest.backend.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "coupons")
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(unique = true, nullable = false)
    private String code;

    @Enumerated(EnumType.STRING)
    private DiscountType discountType;

    private Double value;

    private Double minOrderAmount;

    private Integer maxUses;


    @Builder.Default
    private Integer usedCount = 0;

    private LocalDate expiryDate;

    @Builder.Default
    private Boolean active = true;
}