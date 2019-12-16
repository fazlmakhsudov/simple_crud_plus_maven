package com.example.service;

import java.util.List;

/**
 * Service generic pattern, wraps repository pattern, provides user-oriented method names
 * @param <T>
 */
public interface GenericService<T> {

    long add(T item);

    T find(long id);

    boolean save(T item);

    boolean remove(long id);

    List<T> findAll();
}
