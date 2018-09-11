package com.sdyin.demo.async.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author: liuye
 * @Date: 2018/9/11 10:58
 * @Description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class TestAsync2Test {
  @Autowired
  private TestAsync testAsync;

  @Test
  public void test(){
    System.out.println("开始执行请求");
    testAsync.test();
    System.out.println("执行请求完成");
  }

}