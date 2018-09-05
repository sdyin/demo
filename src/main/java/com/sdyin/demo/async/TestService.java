package com.sdyin.demo.async;

import org.springframework.scheduling.annotation.Async;

/**
 * @author: liuye
 * @Date: 2018/9/5 21:53
 * @Description
 */
public interface TestService {
  @Async
  void doOtherThing();
}
