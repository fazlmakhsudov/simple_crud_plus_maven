package com.example.action.impl;


import com.example.action.Action;
import com.example.util.Fields;
import com.example.util.Request;

public class ActionIndex implements Action {

    public ActionIndex() {

    }

    @Override
    public String execute(Request request) {
        return Fields.ACTION_INDEX;
    }

}
