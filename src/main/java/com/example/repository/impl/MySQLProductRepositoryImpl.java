package com.example.repository.impl;

import com.example.entity.Product;
import com.example.repository.ProductRepository;
import com.example.util.DBUtil;

import java.util.List;

public class MySQLProductRepositoryImpl implements ProductRepository {


    private final DBUtil dbUtil;

    public MySQLProductRepositoryImpl(DBUtil dbUtil) {
        this.dbUtil = dbUtil;
    }

    @Override
    public long create(Product item) {
        return dbUtil.add(item);
    }

    @Override
    public Product read(long id) {
        return dbUtil.get(id);
    }

    @Override
    public boolean update(Product item) {
        return dbUtil.save(item);
    }

    @Override
    public boolean delete(long id) {
        return dbUtil.remove(id);
    }

    @Override
    public List<Product> getAll() {
        return dbUtil.getAll();
    }
}
