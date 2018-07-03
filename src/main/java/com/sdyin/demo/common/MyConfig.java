package com.sdyin.demo.common;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: liuye
 * @Date: 2018/6/30 10:10
 */
@Configuration
public class MyConfig {

  /**
   * servlets: 只是一个请求,所有符合该路径匹配的请求都会进入该方法
   * @return
   */
  @Bean
  public ServletRegistrationBean myServlet(){
    ServletRegistrationBean myServlet = new ServletRegistrationBean();
    myServlet.addUrlMappings("/api/*");
    myServlet.setServlet( new MyServlet());
    return myServlet;
  }

  /**
   * filter
   * @return
   */
  @Bean
  public FilterRegistrationBean myFilter(){
    FilterRegistrationBean myFilter = new FilterRegistrationBean();
    myFilter.addUrlPatterns("/*");
    myFilter.setFilter( new MyFilter());
    return myFilter;
  }

  /**
   * listen
   * @return
   */
  @Bean
  public ServletListenerRegistrationBean myListen(){
    ServletListenerRegistrationBean myListen = new ServletListenerRegistrationBean();
    myListen.setListener(new MyListen());
    return myListen;
  }
}
