package com.example.repository.impl;

import com.example.entity.User;
import com.example.repository.UserRepository;
import com.example.util.UserGoogleDriveUtil;

import java.util.List;

/**
 * Class implements GenericRepository for Google drive
 */
public class GoogleDriveUserRepositoryImpl implements UserRepository<User> {


    private final UserGoogleDriveUtil googleDriveUtil;

    public GoogleDriveUserRepositoryImpl(UserGoogleDriveUtil googleDriveUtil) {
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

    @Override
    public User getUserByNameAndSurname(String name, String surname) {
        return googleDriveUtil.getUserByNameAndSurname(name, surname);
    }
}
