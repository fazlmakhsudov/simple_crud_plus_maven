package com.example.command_pattern_mf;

import com.example.command_pattern_mf.controller.FrontController;
import com.example.entity.Article;
import com.example.entity.User;
import com.example.repository.ArticleRepository;
import com.example.repository.UserRepository;
import com.example.repository.impl.InMemoryArticleRepositoryImpl;
import com.example.repository.impl.InMemoryUserRepositoryImpl;
import com.example.service.ArticleService;
import com.example.service.UserService;
import com.example.service.impl.ArticleServiceImpl;
import com.example.service.impl.UserServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class Demo {
    public static void main(String[] args) {
        Map<Long, User> userMap = new HashMap<>();
        UserRepository userRepository = new InMemoryUserRepositoryImpl(userMap, 0);
        UserService userService = new UserServiceImpl(userRepository);
        userService.add(User.valueOf("Benjamen", "Warlts", 11));
        userService.add(User.valueOf("Bob", "Marli", 13));
        userService.add(User.valueOf("Subaru", "Shults", 14));

        Map<Long, Article> articleMap = new HashMap<>();
        ArticleRepository articleRepository = new InMemoryArticleRepositoryImpl(articleMap, 0);
        ArticleService articleService = new ArticleServiceImpl(articleRepository);
        articleService.add(Article.valueOf("Silent ocean", "Once upon a time in silent ocean", 0));
        articleService.add(Article.valueOf("Atlantic ocean", "Once upon a time in atlantic ocean", 1));
        articleService.add(Article.valueOf("Arctic ocean", "Once upon a time in arctic ocean", 2));

        Map<String, Object> pocket = new HashMap<>();
        pocket.put("userService", userService);
        pocket.put("articleService", articleService);
        FrontController frontController = new FrontController(pocket);
        frontController.start();
    }
}
