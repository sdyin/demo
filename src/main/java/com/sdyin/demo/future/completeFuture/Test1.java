package com.sdyin.demo.future.completeFuture;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;

/**
 * @author: liuye
 * @Date: 2018/8/20 21:52
 * @Description
 */
public class Test1 {

  public static void main(String[] args) {

    //TODO  示例待续
    CompletableFuture<Double> comFuture = new CompletableFuture<>();
    Callable c = () -> {
      Double d1 = 2.3;
      return comFuture.complete(d1);
    };

  }
}
