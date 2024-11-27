package com.assignment.product_category.service;
import com.assignment.product_category.model.Category;
import org.springframework.data.domain.Page;
import java.util.Optional;

public interface CategoryService {
    public Category SaveCategory(Category category);
    public Optional<Category> getCategoryById(Integer id);
    public Page<Category> getAllCategory(Integer no, Integer size);
    Optional<Category> UpdateCategory(Integer id, Category updatedCategory);
    public void deleteCategoryById(Integer id);

}
