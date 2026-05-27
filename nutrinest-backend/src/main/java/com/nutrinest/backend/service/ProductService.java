package com.nutrinest.backend.service;
import com.nutrinest.backend.dto.ProductRequest;
import com.nutrinest.backend.model.Product;

import java.util.List;

public interface ProductService {

    Product create(ProductRequest request);
    List<Product> getAll();
    Product update(String id, ProductRequest request);
    void delete(String id);
}