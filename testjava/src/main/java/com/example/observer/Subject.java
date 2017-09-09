package com.example.observer;

/**
 * Created by Administrator on 2017/8/31.
 */

public interface Subject {
    /**
     * 绑定观察者
     * @param observer
     */
    public void attach(Observer observer);

    /**
     * 删除观察者
     * @param observer
     */
    public void detach(Observer observer);

    /**
     * 通知观察者
     * @param message
     */
    public void notify(String message);
}
