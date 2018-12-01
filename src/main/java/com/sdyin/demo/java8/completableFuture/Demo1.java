package com.sdyin.demo.java8.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author: liuye
 * @Date: 2018/12/1 11:19
 * @Description
 */
public class Demo1 {

  public static void main(String[] args) throws ExecutionException, InterruptedException {

    //thenApply
    CompletableFuture<String> result = CompletableFuture.supplyAsync(() -> {
      return "hello";
    }).thenApply(value -> {
      return value + " sdyin";
    }).thenApply(value -> {
      System.out.println(value);
      //return value + 1 / 0;
      return value + " welcome";
    }).exceptionally(value -> {
      return value.toString();
    });
    System.out.println("result:"+ result.get().toString());

    //thenAccept
    CompletableFuture.supplyAsync(() -> {
      return "nice";
    }).thenAccept(value->{
      System.out.println(value);
    });

  }

}
