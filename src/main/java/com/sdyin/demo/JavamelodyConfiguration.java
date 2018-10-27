package com.sdyin.demo.common;

import net.bull.javamelody.MonitoringFilter;
import net.bull.javamelody.SessionListener;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: liuye
 * @Date: 2018/10/27 10:58
 * @Description
 */

@Configuration
public class JavamelodyConfiguration {

  @Bean
  public FilterRegistrationBean monitorFilter(){
    FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new MonitoringFilter());
    filterRegistrationBean.addUrlPatterns("/*");
    return filterRegistrationBean;
  }

  @Bean
  public ServletListenerRegistrationBean sessionListener(){
    ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean();
    servletListenerRegistrationBean.setListener(new SessionListener());
    return servletListenerRegistrationBean;
  }



}
