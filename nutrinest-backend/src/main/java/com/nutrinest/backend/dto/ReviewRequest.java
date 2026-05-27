package com.nutrinest.backend.dto;
import lombok.Data;

@Data
public class ReviewRequest {

    private String userId;
    private String productId;
    private int rating;
    private String comment;
}