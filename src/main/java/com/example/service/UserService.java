package com.example.service;

import com.example.entity.User;

/**
 * Service generic pattern, wraps repository pattern, provides user-oriented method names
 */
public interface UserService extends GenericService<User> {

    /**
     * Provide required user with given name and surname
     *
     * @param name
     * @param surname
     * @return user
     */
    User findUserByNameAndSurname(String name, String surname);
}
