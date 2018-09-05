package com.sdyin.demo.async;

import org.springframework.stereotype.Service;

/**
 * @author: liuye
 * @Date: 2018/9/5 21:54
 * @Description
 */
@Service
public class TestServiceImpl implements TestService {


  @Override
  public void doOtherThing() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("执行异步任务");
  }
}
