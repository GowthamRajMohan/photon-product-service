package com.example.product.service;


import com.example.product.data.Product;
import com.example.product.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {

    private final ProductRepository productRepository;


    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProductById(Long id) {
        try {
            return productRepository.getReferenceById(id);
        } catch (EntityNotFoundException exception) {
            System.out.println("Entity not found for the id: " + id + " " + exception);
            return null;
        }
    }

    public List<Product> getAllProducts() {
        try {
            return productRepository.findAll();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception);
            return null;
        }
    }
}
