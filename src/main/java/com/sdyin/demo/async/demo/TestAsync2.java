package com.sdyin.demo.async.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liuye
 * @Date: 2018/9/10 21:52
 * @Description
 */
@RestController
@RequestMapping("/test")
public class TestAsync2 {

  @Autowired
  private TestAsync testAsync;

  @RequestMapping("/async")
  public void test(){
    System.out.println("开始执行请求");
    testAsync.test();
    System.out.println("执行请求完成");
  }

}
