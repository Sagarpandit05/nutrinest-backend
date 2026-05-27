package com.nutrinest.backend.service.impl;

import com.nutrinest.backend.dto.ReviewRequest;
import com.nutrinest.backend.model.Product;
import com.nutrinest.backend.model.Review;
import com.nutrinest.backend.model.User;
import com.nutrinest.backend.repository.ProductRepository;
import com.nutrinest.backend.repository.ReviewRepository;
import com.nutrinest.backend.repository.UserRepository;
import com.nutrinest.backend.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @Override
    public Review create(ReviewRequest request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Review review = new Review();
        review.setUser(user);
        review.setProduct(product);
        review.setRating(request.getRating());
        review.setComment(request.getComment());
        review.setCreatedAt(LocalDateTime.now());

        return reviewRepository.save(review);
    }

    @Override
    public List<Review> getByProduct(String productId) {
        return reviewRepository.findByProduct_ProductId(productId);
    }

    @Override
    public void delete(String reviewId) {
        reviewRepository.deleteById(reviewId);
    }
}
