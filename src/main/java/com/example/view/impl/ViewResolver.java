/**
 *
 */
package com.example.view.impl;


import com.example.util.Fields;
import com.example.util.Request;
import com.example.view.View;

import java.util.Map;
import java.util.TreeMap;

public final class ViewResolver {

    private Map<String, View> views = new TreeMap<String, View>();

    public ViewResolver(Map<String, View> views) {
        this.views = views;
    }

    public void resolve(String name, Request request) {
        View view = get(name);
        view.view(request);
    }

    private View get(final String name) {
        if (name == null || !views.containsKey(name)) {
            return views.get(Fields.ACTION_NOTFOUND);
        }
        return views.get(name);
    }
}
