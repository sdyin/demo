package com.sdyin.demo.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author: liuye
 * @Date: 2018/9/19 19:53
 * @Description
 */
@RestController
@RequestMapping("/annotation")
@PropertySource(value = "classpath:schedule.properties")
public class TestAnnotationController {

  @Scheduled(cron = "${task.executor}")
  @RequestMapping("/test")
  public String test(){
    Date date = new Date();
    System.out.println("定时执行查询:" + date);
    return null;
  }


  @Bean
  public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
    return new PropertySourcesPlaceholderConfigurer();
  }


}
