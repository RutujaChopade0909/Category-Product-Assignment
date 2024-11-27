package com.assignment.product_category.service;

import com.assignment.product_category.model.Product;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface ProductService {
    public Product SaveProduct(Product product);
   public Optional<Product> getProductById(Integer id);
   public Page<Product> getAllProduct(Integer no, Integer size);
    Optional<Product> UpdateProduct(Integer id, Product updatedProduct);
    public void deleteProductById(Integer id);

}
