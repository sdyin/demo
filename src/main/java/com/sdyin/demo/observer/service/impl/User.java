package com.sdyin.demo.observer.service.impl;

import com.sdyin.demo.observer.service.ObserverUser;

/**
 * @Description 观察者实现类
 * @Author liuye
 * @Date 2019/5/21 11:05
 */
public class User implements ObserverUser {

    private String name;
    private String message;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        this.message = message;
        System.out.println(name + " 收到推送消息： " + message);
    }

}
