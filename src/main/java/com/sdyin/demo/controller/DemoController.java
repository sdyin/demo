package com.sdyin.demo.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @Author: liuye
 * @Date: 2018/6/28 14:24
 */
@RestController
@RequestMapping("/controller")
public class DemoController {

  @GetMapping(value = "/test")
  public String test(){
    System.out.println("执行test");
    return "test";
  }

  @GetMapping(value = "/api/test")
  public String api(){
    System.out.println("执行api");
    return "api";
  }

}
