package com.example;

import com.example.entity.Product;
import com.example.repository.ProductRepository;
import com.example.repository.impl.InMemoryProductRepositoryImpl;
import com.example.repository.impl.MySQLProductRepositoryImpl;
import com.example.service.ProductService;
import com.example.service.impl.ProductServiceImpl;
import com.example.util.DBUtil;

import java.util.HashMap;
import java.util.Map;

public class Demo {

    public static void main(String[] args) {


        final Map<Long, Product> memory = new HashMap<>();

        final ProductRepository productRepository = new InMemoryProductRepositoryImpl(memory, 1);

        ProductService productService = new ProductServiceImpl(productRepository);

        productService.add(Product.valueOf("memory product 1", "description 1"));
        productService.add(Product.valueOf("memory product 2", "description 1"));
        productService.add(Product.valueOf("memory product 3", "description 1"));

        System.out.println("=================== SHOW ALL DATA FROM LOCAL MEMORY ======================");
        for (Product product : productService.findAll()) {
            System.out.println(String.format("Product id: %s, name: %s", product.getId(), product.getName()));
        }

        final DBUtil mysqlDB = new DBUtil();

        productService = new ProductServiceImpl(new MySQLProductRepositoryImpl(mysqlDB));
        productService.add(Product.valueOf("mysql product 1", "description 1"));
        productService.add(Product.valueOf("mysql product 2", "description 1"));
        productService.add(Product.valueOf("mysql product 3", "description 1"));

        System.out.println("=================== SHOW ALL DATA FROM FAKE MYSQL DB ======================");
        for (Product product : productService.findAll()) {
            System.out.println(String.format("Product id: %s, name: %s", product.getId(), product.getName()));
        }


    }


}
