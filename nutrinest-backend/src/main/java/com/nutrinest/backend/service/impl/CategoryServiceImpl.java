package com.nutrinest.backend.service.impl;

import com.nutrinest.backend.dto.CategoryRequest;
import com.nutrinest.backend.model.Category;
import com.nutrinest.backend.repository.CategoryRepository;
import com.nutrinest.backend.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category create(CategoryRequest request) {

        if (categoryRepository.findByCategoryName(request.getCategoryName()).isPresent()) {
            throw new RuntimeException("Category already exists");
        }

        Category category = new Category();
        category.setCategoryName(request.getCategoryName());
        category.setDescription(request.getDescription());

        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category update(String id, CategoryRequest request) {

        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        category.setCategoryName(request.getCategoryName());
        category.setDescription(request.getDescription());

        return categoryRepository.save(category);
    }

    @Override
    public void delete(String id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category getById(String id) {
        return categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("category is not Founds"));
    }
}