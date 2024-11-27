package com.assignment.product_category.controller;

import com.assignment.product_category.model.Product;
import com.assignment.product_category.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("api")
@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("saveProduct")
    public Product Save(@RequestBody Product product) {
        return productService.SaveProduct(product);
    }

    @GetMapping("getProductById/{id}")
   public Optional<Product> getById(@PathVariable Integer id) {
       return productService.getProductById(id);
    }

   @GetMapping("getAllProducts/{no}/{size}")
  public Page<Product> getAllProduct(@PathVariable Integer no,@PathVariable Integer size) {
        return productService.getAllProduct(no, size);
   }

    @PutMapping("updateProduct/{id}")
    public Optional<Product> UpdateProduct(@PathVariable Integer id,@RequestBody Product product) {
        return productService.UpdateProduct(id,product);
    }
    @DeleteMapping("deleteProductById/{id}")
    public void deleteById(@PathVariable Integer id) {
        productService.deleteProductById(id);
    }
}
