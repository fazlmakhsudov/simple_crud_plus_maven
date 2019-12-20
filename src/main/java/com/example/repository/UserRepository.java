package com.example.repository;

import org.apache.poi.ss.formula.functions.T;

import java.util.List;

public interface UserRepository<User> extends GenericRepository <User>{
    /**
     * Retrieve User with certain name and surname
     * @param name
     * @param surname
     * @return user
     */
    User getUserByNameAndSurname(String name, String surname);

}
