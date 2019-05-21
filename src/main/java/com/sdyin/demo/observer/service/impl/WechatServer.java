package com.sdyin.demo.observer.service.impl;

import com.sdyin.demo.observer.service.ObserverUser;
import com.sdyin.demo.observer.service.Observerable;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;


/**
 * 被观察者实现类，可以理解为微信公众号服务
 * @Description
 * @Author liuye
 * @Date 2019/5/21 10:57
 */
public class WechatServer implements Observerable{

    //注意到这个List集合的泛型参数为Observer接口，设计原则：面向接口编程而不是面向实现编程
    private List<ObserverUser> list;
    private String message;

    public WechatServer() {
        list = new ArrayList<ObserverUser>();
    }

    @Override
    public void registerObserver(ObserverUser o) {
        list.add(o);
    }

    @Override
    public void removeObserver(ObserverUser o) {
        if(!list.isEmpty()){
            list.remove(o);
        }
    }

    @Override
    public void notifyObserver() {
        for(int i = 0; i < list.size(); i++) {
            ObserverUser oserver = list.get(i);
            oserver.update(message);
        }
    }

    public void setInfomation(String s) {
        this.message = s;
        System.out.println("微信服务更新消息： " + s);
        //消息更新，通知所有观察者
        notifyObserver();
    }
}
