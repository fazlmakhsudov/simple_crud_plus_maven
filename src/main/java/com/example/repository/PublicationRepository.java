package com.example.repository;

import com.example.entity.Article;

import java.util.List;

public interface PublicationRepository <T> extends GenericRepository <T>{
    /**
     * Retrieve publications of certain user
     * @param user_id
     * @return list of publications
     */
    List<T> getAllByUserId(long user_id);

    /**
     * Retrieve publication by title
     * @param title
     * @return list of publication
     */
    T getByTitle(String title);

}
