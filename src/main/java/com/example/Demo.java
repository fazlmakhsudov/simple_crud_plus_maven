package com.example;

import com.example.entity.Article;
import com.example.entity.User;
import com.example.repository.ArticleRepository;
import com.example.repository.UserRepository;
import com.example.repository.impl.InMemoryArticleRepositoryImpl;
import com.example.repository.impl.InMemoryUserRepositoryImpl;
import com.example.repository.impl.MySQLUserRepositoryImpl;
import com.example.service.ArticleService;
import com.example.service.UserService;
import com.example.service.impl.ArticleServiceImpl;
import com.example.service.impl.UserServiceImpl;
import com.example.util.UserDBUtil;

import java.util.HashMap;
import java.util.Map;

public class Demo {

    public static void main(String[] args) {


        final Map<Long, User> memory = new HashMap<>();

        final UserRepository<User> UserRepository = new InMemoryUserRepositoryImpl(memory, 1);

        UserService userService = new UserServiceImpl(UserRepository);

        userService.add(User.valueOf("memory User 1", "surname 1", 12));
        userService.add(User.valueOf("memory User 2", "surname 1", 14));
        userService.add(User.valueOf("memory User 3", "surname 1", 16));

        System.out.println("=================== SHOW ALL DATA FROM LOCAL MEMORY ======================");
        for (User user : userService.findAll()) {
            System.out.println(String.format("User id: %s, name: %s", user.getId(), user.getName(), user.getAge()));
        }
        System.out.println("******* " + userService.findUserByNameAndSurname("memory User 1", "surname 1"));
        final UserDBUtil mysqlDB = new UserDBUtil();

        userService = new UserServiceImpl(new MySQLUserRepositoryImpl(mysqlDB));
        userService.add(User.valueOf("mysql User 1", "surname 1", 12));
        userService.add(User.valueOf("mysql User 2", "surname 1", 13));
        userService.add(User.valueOf("mysql User 3", "surname 1", 16));

        System.out.println("=================== SHOW ALL DATA FROM FAKE MYSQL DB ======================");
        for (User user : userService.findAll()) {
            System.out.println(String.format("User id: %s, name: %s    %d", user.getId(), user.getName(), user.getAge()));
        }
        System.out.println("******* " + userService.findUserByNameAndSurname("mysql User 1", "surname 1"));

        final Map<Long, Article> memory2 = new HashMap<>();

        ArticleRepository articlePublicationRepository = new InMemoryArticleRepositoryImpl(memory2, 1);
        ArticleService publicationService = new ArticleServiceImpl(articlePublicationRepository);

        publicationService.add(Article.valueOf("big title", "long far ago was something", 11));
        publicationService.add(Article.valueOf("little title", "long far ago was dog", 12));
        publicationService.add(Article.valueOf("short title", "long far ago cat", 13));
        publicationService.add(Article.valueOf("middle title", "long far ago was dibld", 15));
        publicationService.add(Article.valueOf("short title", "long far ago was unicorn", 11));

        System.out.println("=================== SHOW ALL DATA FROM LOCAL MEMORY for Article ======================");
        for (Article article : publicationService.findAll()) {
            System.out.println(String.format("Article id: %s  , title: %s     #%s#        %d", article.getId(), article.getTitle(), article.getText(), article.getUser_id()));
        }
        System.out.println(publicationService.findAllByUserId(11));
        System.out.println(publicationService.findByTitle("short title"));
    }


}
