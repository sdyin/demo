package com.sdyin.demo.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liuye
 * @Date: 2018/9/5 21:51
 * @Description
 */
@RestController
@RequestMapping("/test")
public class TestController {

  @Autowired
  private TestService testService;

  @RequestMapping("/test")
  public void test(){
    System.out.println("开始执行");
    testService.doOtherThing();
    System.out.println("执行完成");
  }
}
