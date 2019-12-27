/**
 *
 */
package com.example.view.impl;

import com.example.util.Request;
import com.example.view.View;


public class ViewNotFound implements View {

    @Override
    public void view(Request request) {
        System.out.println("ERROR 404");

    }

}
