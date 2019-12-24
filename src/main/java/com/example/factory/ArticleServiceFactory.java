package com.example.factory;

import com.example.entity.Article;
import com.example.repository.impl.InMemoryArticleRepositoryImpl;
import com.example.service.ArticleService;
import com.example.service.impl.ArticleServiceImpl;

import java.util.Map;

/**
 * Factory class for ArticleService
 */
public class ArticleServiceFactory {
    private Map<Long, Article> articleMap;

    public ArticleServiceFactory(Map<Long, Article> articleMap) {
        this.articleMap = articleMap;
    }

    public Map<Long, Article> getArticleMap() {
        return articleMap;
    }

    public void setArticleMap(Map<Long, Article> articleMap) {
        this.articleMap = articleMap;
    }

    /**
     * Factory method for ArticleService
     *
     * @param sourceType
     * @return
     */
    public ArticleService getArticleService(String sourceType) {
        ArticleService articleService = null;
        MemoryType memoryType = MemoryType.getMemoryType(sourceType);
        switch (memoryType) {
            case INMEMORY:
                articleService = new ArticleServiceImpl(new InMemoryArticleRepositoryImpl(articleMap, 0));
                break;
            default:
                System.out.println("No match ArticleServleImpl");
        }
        return articleService;
    }

}
