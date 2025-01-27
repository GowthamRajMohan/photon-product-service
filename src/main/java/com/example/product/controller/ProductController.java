package com.example.product.controller;

import com.example.product.data.Product;
import com.example.product.service.ProductService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        if(product != null) {
            return new ResponseEntity<>(product, HttpStatusCode.valueOf(201));
        } else {
            return new ResponseEntity<>(HttpStatusCode.valueOf(404));
        }
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = productService.getAllProducts();
        if(!products.isEmpty()) {
            return new ResponseEntity<>(products, HttpStatusCode.valueOf(201));
        } else {
            return new ResponseEntity<>(HttpStatusCode.valueOf(404));
        }
    }


}
