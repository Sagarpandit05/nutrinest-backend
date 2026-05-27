package com.nutrinest.backend.repository;

import com.nutrinest.backend.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, String> {

    List<Review> findByProduct_ProductId(String productId);
}
