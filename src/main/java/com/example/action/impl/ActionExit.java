package com.example.action.impl;


import com.example.action.Action;
import com.example.util.Fields;
import com.example.util.Request;

public class ActionExit implements Action {

    public ActionExit() {
    }

    @Override
    public String execute(Request request) {
        request.clear();
        return Fields.ACTION_EXIT;
    }

}
