package com.example.repository.impl;

import com.example.entity.User;
import com.example.repository.GenericRepository;
import com.example.util.EntityGoogleDriveUtil;

import java.util.List;

/**
 * Class implements GenericRepository for Google drive
 */
public class GoogleDriveUserRepositoryImpl implements GenericRepository<User> {


    private final EntityGoogleDriveUtil<User> googleDriveUtil;

    public GoogleDriveUserRepositoryImpl(EntityGoogleDriveUtil<User> googleDriveUtil) {
        this.googleDriveUtil = googleDriveUtil;
    }

    @Override
    public long create(User item) {
        return googleDriveUtil.add(item);
    }

    @Override
    public User read(long id) {
        return googleDriveUtil.get(id);
    }

    @Override
    public boolean update(User item) {
        return googleDriveUtil.save(item);
    }

    @Override
    public boolean delete(long id) {
        return googleDriveUtil.remove(id);
    }

    @Override
    public List<User> getAll() {
        return googleDriveUtil.getAll();
    }
}
