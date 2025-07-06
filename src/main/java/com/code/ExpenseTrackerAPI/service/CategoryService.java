package com.code.ExpenseTrackerAPI.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.code.ExpenseTrackerAPI.entity.Category;
import com.code.ExpenseTrackerAPI.repository.CategoryRepository;

@Service
// This service handles the categories
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // This method creates a new category
    public void createCategory(Category category) {
        categoryRepository.save(category);
    }

    // This method lists all the categories
    public List<Category> listAllCategories() {
        return categoryRepository.findAll();
    }

    // This method updates the category by id
    public void updateCategory(Long id, Category category) {
        category.setId(id);
        categoryRepository.save(category);
    }

    // This method deletes the category by id
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}