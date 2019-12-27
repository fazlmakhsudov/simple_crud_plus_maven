package com.example.util;

import com.example.action.impl.*;
import com.example.controller.FrontController;
import com.example.service.ArticleService;
import com.example.service.UserService;
import com.example.view.View;
import com.example.view.impl.*;

import java.util.Map;
import java.util.TreeMap;


public class InitializeConsole {

    private FrontController frontController;
    private UserService userService;
    private ArticleService articleService;


    public InitializeConsole() {
    }

    public InitializeConsole(UserService userService, ArticleService articleService) {
        this.userService = userService;
        this.articleService = articleService;
    }

    public void init() {
        initController();
        initFrontController();
    }

    private void initController() {
        frontController = new FrontController();
    }

    public FrontController getFrontController() {
        return frontController;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public ArticleService getArticleService() {
        return articleService;
    }

    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    private void initFrontController() {
        Map<Integer, com.example.action.Action> actions = new TreeMap<>();
        Map<String, com.example.view.View> views = new TreeMap<>();
        initActions(actions);
        initViews(views);
        frontController.setActionHolder(new ActionHolder(actions));
        frontController.setViewResolver(new ViewResolver(views));
    }


    private void initActions(Map<Integer, com.example.action.Action> actions) {
        int k = 0;
        actions.put(k++, new ActionIndex());
        actions.put(k++, new ActionUsers(userService));
        actions.put(k++, new ActionArticles(articleService));
        actions.put(k, new ActionExit());
        actions.put(404, new Action404());
    }

    private void initViews(Map<String, View> views) {
        views.put(Fields.ACTION_INDEX, new ViewIndex());
        views.put(Fields.ACTION_EXIT, new ViewExit());
        views.put(Fields.ACTION_NOTFOUND, new ViewNotFound());
        views.put(Fields.ACTION_ALL_USERS, new ViewUsers());
        views.put(Fields.ACTION_ALL_ARTICLES, new ViewArticles());


    }


}
