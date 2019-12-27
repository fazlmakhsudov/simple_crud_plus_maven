package com.example.controller;

import com.example.action.Action;
import com.example.action.impl.ActionHolder;
import com.example.util.Request;
import com.example.view.impl.ViewResolver;


public class FrontController {
    private Request request;
    private ViewResolver view;
    private ActionHolder actionHolder;


    public FrontController() {
        this.request = new Request();
    }


    public void setActionHolder(ActionHolder holder) {
        this.actionHolder = holder;
    }


    public void setViewResolver(ViewResolver viewResolver) {
        this.view = viewResolver;
    }


    public final void start(Integer actionNum) {
        Action action = actionHolder.get(actionNum);
        String viewName = action.execute(request);
        view.resolve(viewName, request);
    }

}
