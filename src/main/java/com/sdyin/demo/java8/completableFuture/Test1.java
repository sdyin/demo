package com.sdyin.demo.java8.completableFuture;

import java.util.concurrent.*;

/**
 * @Author: liuye
 * @Date: 2018/6/26 13:54
 */
public class Test1 {
  public static void main(String[] args) {
    Shop shop = new Shop("BestShop");
    long start = System.nanoTime();
    Future<Double> futurePrice = shop.getPriceAsync("my favorite product");
    long invocationTime = ((System.nanoTime() - start) / 1_000_000);
    System.out.println("Invocation returned after " + invocationTime
            + " msecs");
// 执行更多任务，比如查询其他商店
   // doSomethingElse();
// 在计算商品价格的同时
    try {
      double price = futurePrice.get();
      System.out.printf("Price is %.2f%n", price);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
    System.out.println("Price returned after " + retrievalTime + " msecs");

    //异步无返回值
    CompletableFuture.runAsync(()->{
      System.out.println("异步1:"+ Thread.currentThread().getName());
    });
    //异步有返回值
    CompletableFuture.supplyAsync(()->{
      System.out.println("异步2:"+ Thread.currentThread().getName());
      return "";
    });

  }
}
