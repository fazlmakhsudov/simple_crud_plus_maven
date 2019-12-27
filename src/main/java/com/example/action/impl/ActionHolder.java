package com.example.action.impl;

import com.example.action.Action;

import java.util.Map;

public final class ActionHolder {
    private Map<Integer, Action> actions;

    public ActionHolder(Map<Integer, Action> actions) {
        this.actions = actions;

    }

    public Action get(final Integer action) {
        if (action == null || !actions.containsKey(action)) {
            return actions.get(404);
        }
        return actions.get(action);
    }

}
