package com.nutrinest.backend.service;

import com.nutrinest.backend.dto.ReviewRequest;
import com.nutrinest.backend.model.Review;

import java.util.List;

public interface ReviewService {

    Review create(ReviewRequest request);
    List<Review> getByProduct(String productId);
    void delete(String reviewId);
}
