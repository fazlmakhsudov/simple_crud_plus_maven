package com.example.repository.impl;

import com.example.entity.User;
import com.example.repository.GenericRepository;
import com.example.util.EntityDBUtil;

import java.util.List;

/**
 * Class implements GenericRepository for MySQL database
 */
public class MySQLUserRepositoryImpl implements GenericRepository<User> {


    private final EntityDBUtil<User> dbUtil;

    public MySQLUserRepositoryImpl(EntityDBUtil<User> dbUtil) {
        this.dbUtil = dbUtil;
    }

    @Override
    public long create(User item) {
        return dbUtil.add(item);
    }

    @Override
    public User read(long id) {
        return dbUtil.get(id);
    }

    @Override
    public boolean update(User item) {
        return dbUtil.save(item);
    }

    @Override
    public boolean delete(long id) {
        return dbUtil.remove(id);
    }

    @Override
    public List<User> getAll() {
        return dbUtil.getAll();
    }
}
