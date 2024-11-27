package com.assignment.product_category.serviceimplementation;
import com.assignment.product_category.model.Product;
import com.assignment.product_category.repository.ProductRepository;
import com.assignment.product_category.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImplementation implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product SaveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> getProductById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public Page<Product> getAllProduct(Integer no, Integer size) {
        Pageable pageable = PageRequest.of(no, size);
        Page<Product> productList = productRepository.findAll(pageable);
        return productList;
    }


    @Override
    public Optional<Product> UpdateProduct(Integer id, Product updatedProduct) {
            return productRepository.findById(id)
                    .map(existing -> {
                        existing.setP_name(updatedProduct.getP_name());
                        existing.setP_id(updatedProduct.getP_id());
                        existing.setDiscount(updatedProduct.getDiscount());
                        existing.setPrice(updatedProduct.getPrice());
                        return productRepository.save(existing);
                    });
    }

    @Override
    public void deleteProductById(Integer id) {
        productRepository.deleteById(id);
    }
}
