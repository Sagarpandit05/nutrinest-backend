package com.nutrinest.backend.controller;

import com.nutrinest.backend.dto.ProductRequest;
import com.nutrinest.backend.model.Product;
import com.nutrinest.backend.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public Product create(@RequestBody ProductRequest request) {
        return productService.create(request);
    }

    @GetMapping
    public List<Product> getAll() {
        return productService.getAll();
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable String id, @RequestBody ProductRequest request) {
        return productService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        productService.delete(id);
    }
}