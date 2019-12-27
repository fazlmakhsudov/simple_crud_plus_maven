package com.example.action.impl;


import com.example.action.Action;
import com.example.entity.User;
import com.example.service.UserService;
import com.example.util.Fields;
import com.example.util.Request;

import java.util.HashMap;
import java.util.Map;

public class ActionUsers implements Action {
    private UserService userService;

    public ActionUsers() {
    }

    public ActionUsers(UserService userService) {
        this.userService = userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(Request request) {
        Map<Integer, User> map = new HashMap<>();
        for (User user : userService.findAll()) {
            map.put((int) user.getId(), user);
        }
        request.set("users", map);
        return Fields.ACTION_ALL_USERS;
    }

}
