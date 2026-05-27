package com.nutrinest.backend.dto;

import lombok.Data;

@Data
public class CategoryRequest {
    private String categoryName;
    private String description;
}