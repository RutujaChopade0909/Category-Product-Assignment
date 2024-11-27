package com.assignment.product_category.serviceimplementation;

import com.assignment.product_category.model.Category;
import com.assignment.product_category.repository.CategoryRepository;
import com.assignment.product_category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImplementation implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Category SaveCategory(Category category) {
        return categoryRepository.save(category);
    }


  @Override
   public Optional<Category> getCategoryById(Integer id) {
        return categoryRepository.findById(id);
   }

    @Override
   public Page<Category> getAllCategory(Integer no, Integer size) {
        Pageable pageable = PageRequest.of(no, size);
        Page<Category> all = categoryRepository.findAll(pageable);
      return all;
  }



    @Override
   public Optional<Category> UpdateCategory(Integer id, Category updatedCategory) {
        return categoryRepository.findById(id)
             .map(existingCategory -> {
                   existingCategory.setC_name(updatedCategory.getC_name());
                    existingCategory.setC_id(updatedCategory.getC_id());
                    existingCategory.setC_description(updatedCategory.getC_description());
                    return categoryRepository.save(existingCategory);
                });
   }
   @Override
    public void deleteCategoryById(Integer id) {
        categoryRepository.deleteById(id);
    }
}
