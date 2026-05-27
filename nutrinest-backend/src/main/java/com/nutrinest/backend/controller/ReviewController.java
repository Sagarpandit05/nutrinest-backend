package com.nutrinest.backend.controller;

import com.nutrinest.backend.dto.ReviewRequest;
import com.nutrinest.backend.model.Review;
import com.nutrinest.backend.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ReviewController {

    private final ReviewService  reviewService;

    // CREATE
    @PostMapping
    public Review create(@RequestBody ReviewRequest request) {
        return reviewService.create(request);
    }

    // GET by product
    @GetMapping("/{productId}")
    public List<Review> getByProduct(@PathVariable String productId) {
        return reviewService.getByProduct(productId);
    }

    // DELETE
    @DeleteMapping("/{reviewId}")
    public void delete(@PathVariable String reviewId) {
        reviewService.delete(reviewId);
    }
}
