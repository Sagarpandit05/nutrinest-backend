package com.nutrinest.backend.controller;

import com.nutrinest.backend.dto.CategoryRequest;
import com.nutrinest.backend.model.Category;
import com.nutrinest.backend.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CategoryController {

    private final CategoryService categoryService;

    // CREATE
    @PostMapping
    public Category create(@RequestBody CategoryRequest request) {
        return categoryService.create(request);
    }
    @GetMapping("/{id}")
    public Category getById(@PathVariable String id) {
        return categoryService.getById(id);
    }
    // READ ALL
    @GetMapping
    public List<Category> getAll() {
        return categoryService.getAll();
    }

    // UPDATE
    @PutMapping("/{id}")
    public Category update(@PathVariable String id, @RequestBody CategoryRequest request) {
        return categoryService.update(id, request);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        categoryService.delete(id);
    }
}