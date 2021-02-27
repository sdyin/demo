package com.sdyin.demo.tomcat.classloader;

/**
 * @Description:
 * @Author: liuye
 * @time: 2021/2/27$ 上午10:50$
 */
public class User {

    private int id;
    private String name;

    public User(){
    }

    public User(final int id, final String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void sout(){
        System.out.println("==========自定义加载器类调用方法============");
    }
}
