package com.example.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体被观察者
 * Created by Administrator on 2017/8/31.
 */

public class SubscriptionSubject implements Subject {
    private List<Observer> weixinUserlist = new ArrayList<Observer>();
    @Override
    public void attach(Observer observer) {
        weixinUserlist.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        weixinUserlist.remove(observer);
    }

    @Override
    public void notify(String message) {
        for (Observer observer:weixinUserlist
             ) {
            observer.update(message);

        }
    }
}
