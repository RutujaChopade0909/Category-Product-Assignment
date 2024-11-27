package com.assignment.product_category.controller;

import com.assignment.product_category.model.Category;
import com.assignment.product_category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("api")
@RestController
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @PostMapping("saveCategory")
    public Category Save(@RequestBody Category category) {
        return categoryService.SaveCategory(category);
    }

    @GetMapping("getCategoryById/{id}")
    public Optional<Category> getById(@PathVariable Integer id) {
       return categoryService.getCategoryById(id);
    }

    @GetMapping("getAllCategory/{no}/{size}")
   public Page<Category> getAllCategory(@PathVariable Integer no,@PathVariable Integer size) {
        return categoryService.getAllCategory(no, size);
    }
   @PutMapping("updateCategory/{id}")
    public Optional<Category> updateCategory(@PathVariable Integer id,@RequestBody Category category) {
        return categoryService.UpdateCategory(id,category);
    }

    @DeleteMapping("deleteCategoryById/{id}")
    public void deleteById(@PathVariable Integer id){
        categoryService.deleteCategoryById(id);
    }
}

