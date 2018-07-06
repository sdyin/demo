package com.sdyin.demo.test;

import com.sdyin.demo.java8.model.Person;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RunAs;

/**
 * @Author: liuye
 * @Date: 2018/6/15 10:47
 */
@RestController
@RequestMapping("/demo")
public class Test {


  @Autowired
  private Test2 test2;

  @RequestMapping("/main2")
  public void main2(String[] args) throws Exception {
    int i;
    test2.test2();
    for (i = 0;i<10;i++){
      Thread.sleep(500);
      System.out.println("i:"+i+" "+ Thread.currentThread().getName());
    }
  }

}
