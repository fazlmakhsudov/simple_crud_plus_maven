package com.example.service;

import com.example.entity.Article;

import java.util.List;

/**
 * Service pattern concerning Article entity
 */
public interface ArticleService extends GenericService<Article> {
    List<Article> findAllByUserId(long user_id);

    Article findByTitle(String title);
}
