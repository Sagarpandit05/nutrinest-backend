package com.nutrinest.backend.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class CouponRequest {

    private String code;
    private String discountType;
    private Double value;
    private Double minOrderAmount;
    private Integer maxUses;
    private LocalDate expiryDate;
}