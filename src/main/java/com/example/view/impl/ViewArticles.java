package com.example.view.impl;


import com.example.entity.Article;
import com.example.util.Request;
import com.example.view.View;

import java.util.Map;


public class ViewArticles implements View {

    @Override
    public void view(Request request) {
        Map<Integer, Article> articles = (Map<Integer, Article>) request.get("articles");
        request.remove("articles");
        System.out.println("=================================ALL ARTICLES===============================");
        generateViewOrders(articles);
        System.out.println("=================================ALL ARTICLES===============================");
    }

    private void generateViewOrders(final Map<Integer, Article> items) {
        if (items == null || items.size() <= 0) {
            System.out.println("User list is empty");
            return;
        }

        for (Integer key : items.keySet()) {
            Article item = items.get(key);
            System.out.println(item.showEntity());
        }

    }

}
