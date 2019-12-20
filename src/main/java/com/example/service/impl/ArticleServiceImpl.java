package com.example.service.impl;

import com.example.entity.Article;
import com.example.repository.ArticleRepository;
import com.example.service.ArticleService;

import java.util.List;

/**
 * implements ArticleService
 */
public class ArticleServiceImpl extends GenericServiceImpl<Article> implements ArticleService {
    private ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        super(articleRepository, "ArticleServiceImpl");
        this.articleRepository = articleRepository;
    }

    @Override
    public List<Article> findAllByUserId(long user_id) {
        logger.info(String.format("FindAllByUserId: long user_id = %d", user_id));
        return articleRepository.getAllByUserId(user_id);
    }

    @Override
    public Article findByTitle(String title) {
        logger.info(String.format("FindByTitle: String title = %s", title));
        return articleRepository.getByTitle(title);
    }
}
