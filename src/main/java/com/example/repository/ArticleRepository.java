package com.example.repository;

import com.example.entity.Article;

import java.util.List;

/**
 * CRUD interface concerning Article entity
 */
public interface ArticleRepository extends GenericRepository<Article> {
    /**
     * Retrieve publications of certain user
     *
     * @param user_id
     * @return list of publications
     */
    List<Article> getAllByUserId(long user_id);

    /**
     * Retrieve publication by title
     *
     * @param title
     * @return list of publication
     */
    Article getByTitle(String title);
}
