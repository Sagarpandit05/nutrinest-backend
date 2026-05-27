package com.nutrinest.backend.dto;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;

@Data
@Builder
public class CouponResponse {

    private String id;
    private String code;
    private String discountType;
    private Double value;
    private Double minOrderAmount;
    private Integer maxUses;
    private Integer usedCount;
    private LocalDate expiryDate;
    private Boolean active;
}
