package com.sdyin.demo.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author: liuye
 * @Date: 2018/6/28 17:51
 */
@Configuration
public class MyConfigInterceptor extends WebMvcConfigurerAdapter{

  /**
   * 配置静态资源
   */
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/");
    super.addResourceHandlers(registry);
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    //addPathPatterns 用于添加拦截规则
    //excludePathPatterns 用于排除拦截
    registry.addInterceptor(new TestInterceptor()).addPathPatterns("/**")
            .excludePathPatterns("/hlladmin/login") //登录页
            .excludePathPatterns("/hlladmin/user/sendEmail") //发送邮箱
            .excludePathPatterns("/hlladmin/user/register") //用户注册
            .excludePathPatterns("/hlladmin/user/login"); //用户登录
    super.addInterceptors(registry);
  }
}
