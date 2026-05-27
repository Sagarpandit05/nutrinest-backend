package com.nutrinest.backend.service;

import com.nutrinest.backend.dto.CategoryRequest;
import com.nutrinest.backend.model.Category;

import java.util.List;

public interface CategoryService {
    Category create(CategoryRequest request);
    List<Category> getAll();
    Category update(String id, CategoryRequest request);
    void delete(String id);
    Category getById(String id);
}