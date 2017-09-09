package com.example.observer;

/**
 * Created by Administrator on 2017/8/31.
 */

public class WinUser implements Observer {
    private String name;

    public WinUser(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name+"---"+message);
    }
}
