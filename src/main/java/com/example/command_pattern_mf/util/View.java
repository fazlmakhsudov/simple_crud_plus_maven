package com.example.command_pattern_mf.util;

import com.example.entity.Article;
import com.example.entity.User;

import java.util.List;
import java.util.Map;

public class View {
    private void showMainMenu() {
        System.out.println("-----------Main Menu-------------");
        System.out.println("0  =>  Main menu");
        System.out.println("1  =>  List all users");
        System.out.println("2  =>  List all articles");
        System.out.println("3  =>  Exit");
    }

    private void showAllUsers(Map<String, Object> pocket) {
        List<User> list = (List<User>) pocket.get(Fields.LIST_ALL_USERS);
        for (User user : list) {
            System.out.println(user.showEntity());
        }
    }

    private void showAllArticles(Map<String, Object> pocket) {
        List<Article> list = (List<Article>) pocket.get(Fields.LIST_ALL_ARTICLES);
        for (Article article : list) {
            System.out.println(article.showEntity());
        }
    }

    private void showExit() {
        System.out.println("Exit .... ");
    }

    private void show404() {
        System.err.println("No such item. Try again");
    }

    public void show(String commandType, Map<String, Object> pocket) {
        switch (commandType) {
            case Fields.HOME:
                showMainMenu();
                break;
            case Fields.LIST_ALL_USERS:
                showAllUsers(pocket);
                break;
            case Fields.LIST_ALL_ARTICLES:
                showAllArticles(pocket);
                break;
            case Fields.EXIT:
                showExit();
                break;
            case Fields.PAGE404:
                show404();
        }
    }
}
