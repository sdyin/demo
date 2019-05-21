package com.sdyin.demo.observer.service;

/**
 * 定义了一个update()方法，当被观察者调用notifyObservers()方法时，观察者的update()方法会被回调。
 * @Description 抽象观察者
 * @Author liuye
 * @Date 2019/5/21 10:55
 */
public interface ObserverUser {

    /**
     *
     * @param message
     */
    void update(String message);
}
