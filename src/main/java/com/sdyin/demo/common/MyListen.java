package com.sdyin.demo.common;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @Author: liuye
 * @Date: 2018/6/30 10:19
 */
public class MyListen implements ServletContextListener {
  @Override
  public void contextInitialized(ServletContextEvent servletContextEvent) {
    System.out.println("自定义监听器:ServletContextListener->contextInitialized");
  }

  @Override
  public void contextDestroyed(ServletContextEvent servletContextEvent) {

  }
}
