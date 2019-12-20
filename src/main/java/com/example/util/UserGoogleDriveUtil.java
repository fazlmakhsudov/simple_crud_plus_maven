package com.example.util;

import com.example.entity.User;

/**
 * DAO class concerning User entity
 */
public class UserGoogleDriveUtil extends EntityGoogleDriveUtil<User> {
    /**
     * Retrieve user of certain name and surname
     *
     * @param name
     * @param surname
     * @return user
     */
    public User getUserByNameAndSurname(String name, String surname) {
        User user_ = null;
        for (User user : driveStorage.values()) {
            if (user.getName().equals(name) && user.getSurName().equals(surname)) {
                user_ = user;
                break;
            }
        }
        return user_;
    }
}
