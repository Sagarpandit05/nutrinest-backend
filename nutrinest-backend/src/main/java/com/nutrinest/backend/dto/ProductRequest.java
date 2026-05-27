package com.nutrinest.backend.dto;

import lombok.Data;

@Data
public class ProductRequest {

    private String productName;
    private String description;
    private double price;
    private double originalPrice;
    private int stockQuantity;
    private String imageUrl;
    private String categoryId;
}