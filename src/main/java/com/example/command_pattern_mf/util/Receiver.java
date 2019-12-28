package com.example.command_pattern_mf.util;

import com.example.service.ArticleService;
import com.example.service.UserService;

import java.util.Map;

public class Receiver {
    private Map<String, Object> pocket;

    public Receiver(Map<String, Object> pocket) {
        this.pocket = pocket;
    }

    public Map<String, Object> getPocket() {
        return pocket;
    }

    public String action(int commandItem) {
        String commandType = null;
        switch (commandItem) {
            case 0:
                commandType = Fields.HOME;
                break;
            case 1:
                pocket.remove(Fields.LIST_ALL_USERS);
                pocket.put(Fields.LIST_ALL_USERS, ((UserService) pocket.get("userService")).findAll());
                commandType = Fields.LIST_ALL_USERS;
                break;
            case 2:
                pocket.remove(Fields.LIST_ALL_ARTICLES);
                pocket.put(Fields.LIST_ALL_ARTICLES, ((ArticleService) pocket.get("articleService")).findAll());
                commandType = Fields.LIST_ALL_ARTICLES;
                break;
            case 3:
                commandType = Fields.EXIT;
                break;
            default:
                commandType = Fields.PAGE404;
        }
        return commandType;
    }
}
