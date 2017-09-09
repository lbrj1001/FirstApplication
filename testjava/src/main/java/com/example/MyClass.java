package com.example;

import com.example.observer.SubscriptionSubject;
import com.example.observer.WinUser;

import java.util.Date;

public class MyClass {
    public static void main(String[] args)
    {
        System.out.println("Hello Java From android Studio,I'm a java module,Are you seen me?");
        System.out.println(new Date());
        SubscriptionSubject subscriptionSubject = new SubscriptionSubject();
        WinUser liangBo = new WinUser("LiangBo");
        WinUser lina = new WinUser("Lina");
        WinUser disanyun = new WinUser("Disanyun");
        subscriptionSubject.attach(liangBo);
        subscriptionSubject.attach(lina);
        subscriptionSubject.attach(disanyun);
        subscriptionSubject.notify("这是谁来了呢？");
    }
}
