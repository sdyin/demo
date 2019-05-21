package com.sdyin.demo.observer.service;

/**
 * @Description 抽象被观察者接口
 * @Author liuye
 * @Date 2019/5/21 10:53
 */
public interface Observerable {

    /**
     * 注册服务
     * @param o
     */
     void registerObserver(ObserverUser o);

    /**
     * 移除服务
     * @param o
     */
     void removeObserver(ObserverUser o);

    /**
     * 通知服务
     */
    void notifyObserver();
}
