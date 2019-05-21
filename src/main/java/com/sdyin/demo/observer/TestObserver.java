package com.sdyin.demo.observer;

import com.sdyin.demo.observer.service.ObserverUser;
import com.sdyin.demo.observer.service.impl.User;
import com.sdyin.demo.observer.service.impl.WechatServer;

import java.util.Observer;

/**
 * @Description 观察者模式测试类
 * @Author liuye
 * @Date 2019/5/21 11:06
 */
public class TestObserver {

    public static void main(String[] args) {
        WechatServer server = new WechatServer();

        ObserverUser userZhang = new User("ZhangSan");
        ObserverUser userLi = new User("LiSi");
        ObserverUser userWang = new User("WangWu");

        server.registerObserver(userZhang);
        server.registerObserver(userLi);
        server.registerObserver(userWang);
        server.setInfomation("PHP是世界上最好用的语言！");

        System.out.println("----------------------------------------------");
        server.removeObserver(userZhang);
        server.setInfomation("JAVA是世界上最好用的语言！");

    }
}
