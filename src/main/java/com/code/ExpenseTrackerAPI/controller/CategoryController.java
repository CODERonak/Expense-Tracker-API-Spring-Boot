package com.code.ExpenseTrackerAPI.controller;

import java.util.List;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.code.ExpenseTrackerAPI.entity.Category;
import com.code.ExpenseTrackerAPI.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // This method creates a new category
    @PostMapping("/add")
    public ResponseEntity<String> registerUser(@RequestBody Category category) {
        categoryService.createCategory(category);
        return new ResponseEntity<>("Category created successfully", HttpStatus.CREATED);
    }

    // This method lists all the categories
    @GetMapping("/list")
    public ResponseEntity<List<Category>> listAllCategories() {
        List<Category> categories = categoryService.listAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    // This method updates the category by id
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateCategory(@PathVariable Long id, @RequestBody Category category) {
        categoryService.updateCategory(id, category);
        return new ResponseEntity<>("Category updated successfully", HttpStatus.OK);
    }

    // This method deletes the category by id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity<>("Category deleted successfully", HttpStatus.NO_CONTENT);
    }

}