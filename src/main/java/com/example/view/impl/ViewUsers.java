package com.example.view.impl;


import com.example.entity.User;
import com.example.util.Request;
import com.example.view.View;

import java.util.Map;


public class ViewUsers implements View {

    @Override
    public void view(Request request) {
        Map<Integer, User> users = (Map<Integer, User>) request.get("users");
        request.remove("users");
        System.out.println("=================================ALL USERS===============================");
        generateViewOrders(users);
        System.out.println("=================================ALL USERS===============================");
    }

    private void generateViewOrders(final Map<Integer, User> items) {
        if (items == null || items.size() <= 0) {
            System.out.println("User list is empty");
            return;
        }

        for (Integer key : items.keySet()) {
            User item = items.get(key);
            System.out.println(item.showEntity());
        }

    }

}
