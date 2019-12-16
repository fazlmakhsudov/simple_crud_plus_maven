package com.example.service.impl;

import com.example.entity.Product;
import com.example.repository.ProductRepository;
import com.example.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public long add(Product item) {
        return productRepository.create(item);
    }

    public Product find(long id) {
        return productRepository.read(id);
    }

    public boolean save(Product item) {
        return productRepository.update(item);
    }

    public boolean remove(long id) {
        return productRepository.delete(id);
    }

    public List<Product> findAll() {
        return productRepository.getAll();
    }
}
