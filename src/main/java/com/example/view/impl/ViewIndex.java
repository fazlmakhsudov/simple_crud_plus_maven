/**
 *
 */
package com.example.view.impl;

import com.example.util.Request;
import com.example.view.View;

/**
 * @author Yosin_Hasan
 *
 */
public class ViewIndex implements View {

    @Override
    public void view(Request request) {
        System.out.println("===========================DEMO===========================");
        System.out.println("=============================WELCOME=============================");
        Integer k = 0;
        System.out.println(generateMenu(k++, "Home"));
        System.out.println(generateMenu(k++, "View all users"));
        System.out.println(generateMenu(k++, "View all articles"));
        System.out.println(generateMenu(k, "Exit"));

    }

    private String generateMenu(final Integer num, final String value) {
        return "=>" + num + " " + value;
    }

}
