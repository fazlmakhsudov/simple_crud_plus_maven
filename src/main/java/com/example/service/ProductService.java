package com.example.service;

import com.example.entity.Product;

import java.util.List;

public interface ProductService {

    long add(Product item);

    Product find(long id);

    boolean save(Product item);

    boolean remove(long id);

    List<Product> findAll();
}
