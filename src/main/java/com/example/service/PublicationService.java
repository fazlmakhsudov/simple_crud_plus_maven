package com.example.service;

import java.util.List;

/**
 * Service generic pattern, wraps repository pattern, provides user-oriented method names
 * @param <T>
 */
public interface PublicationService<T> extends GenericService<T> {

     List<T> findAllByUserId(long user_id);

    T findByTitle(String title);
}
