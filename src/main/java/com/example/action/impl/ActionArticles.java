package com.example.action.impl;


import com.example.action.Action;
import com.example.entity.Article;
import com.example.service.ArticleService;
import com.example.util.Fields;
import com.example.util.Request;

import java.util.HashMap;
import java.util.Map;

public class ActionArticles implements Action {
    private ArticleService articleService;

    public ActionArticles() {
    }

    public ActionArticles(ArticleService articleService) {
        this.articleService = articleService;
    }

    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    @Override
    public String execute(Request request) {
        Map<Integer, Article> map = new HashMap<>();
        for (Article article : this.articleService.findAll()) {
            map.put((int) article.getId(), article);
        }
        request.set("articles", map);
        return Fields.ACTION_ALL_ARTICLES;
    }

}
