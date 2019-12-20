package com.example.service.impl;

import com.example.entity.Article;
import com.example.repository.ArticleRepository;
import com.example.service.ArticleService;

/**
 * implements ArticleService
 */
public class ArticleServiceImpl extends PublicationServiceImpl<Article> implements ArticleService {
    private ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        super(articleRepository, "ArticleServiceImpl");
        this.articleRepository = articleRepository;
    }
}
