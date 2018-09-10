package com.sdyin.demo.async.demo;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author: liuye
 * @Date: 2018/9/10 21:35
 * @Description
 */
@Service
public class TestAsync {

  @Async
  public void test(){
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("异步执行");
  }
}
