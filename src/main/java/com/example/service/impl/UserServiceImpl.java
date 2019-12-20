package com.example.service.impl;

import com.example.entity.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;

/**
 * Implements UserService
 */
public class UserServiceImpl extends GenericServiceImpl<User> implements UserService {
    private UserRepository<User> userRepository;

    public UserServiceImpl(UserRepository<User> userRepository) {
        super(userRepository, "UserServiceImpl");
        this.userRepository = userRepository;
    }

    @Override
    public User findUserByNameAndSurname(String name, String surname) {
        logger.info(String.format("FindUserByNameAndSurname: name = %s, surname = %s", name, surname));
        return userRepository.getUserByNameAndSurname(name, surname);
    }
}
