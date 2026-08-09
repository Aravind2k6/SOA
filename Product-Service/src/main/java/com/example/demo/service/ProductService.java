package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product getProductById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    public Product updateProduct(Product product) {
        return repository.save(product);
    }

    public void deleteProduct(Integer id) {
        repository.deleteById(id);
    }
}