package com.example.util;

import com.example.entity.Entity;
import com.example.entity.User;
import org.apache.poi.ss.formula.functions.T;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DAO class concering User entity
*/
public class UserDBUtil extends EntityDBUtil<User> {
    /**
     * Retrieve user of certain name and surname
     * @param name
     * @param surname
     * @return user
     */
    public User getUserByNameAndSurname(String name, String surname) {
        User user_ = null;
        for (User user : mysqlStorage.values()) {
            if (user.getName().equals(name) && user.getSurName().equals(surname)) {
                user_ = user;
                break;
            }
        }
        return user_;
    }
}
