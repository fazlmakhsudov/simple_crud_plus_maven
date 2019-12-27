package com.example.action.impl;


import com.example.action.Action;
import com.example.util.Fields;
import com.example.util.Request;

public class Action404 implements Action {

    public Action404() {
    }

    @Override
    public String execute(Request request) {
        return Fields.ACTION_NOTFOUND;
    }

}
