package com.examly.springapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.Category;
import com.examly.springapp.repository.CategoryRepository;


@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @PostMapping
    public Category addCategory(@RequestBody Category c) {
        return categoryRepository.save(c);  // ✅ SAVES TO DB
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryRepository.findAll(); // ✅ FROM DB
    }

    @GetMapping("/{id}")
    public Category getMethodName(@PathVariable Long id) {
        Category category = categoryRepository.findById(id).orElse(null);
        return category; // ✅ FROM DB
    }
    
}
