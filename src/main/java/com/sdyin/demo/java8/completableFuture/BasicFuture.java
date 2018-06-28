package com.sdyin.demo.java8.completableFuture;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Completable 异步编程以及事件响应
 * @Author: liuye
 * @Date: 2018/6/26 15:35
 */
public class BasicFuture {

  private static Random rand = new Random();
  private static long t = System.currentTimeMillis();

  static int getMoreData()  {
    System.out.println("begin to start compute");
    try {
      TimeUnit.SECONDS.sleep(1);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("end to compute,passed " + (System.currentTimeMillis()-t));
    return rand.nextInt(1000);
  }

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    CompletableFuture<Integer> future = CompletableFuture.supplyAsync(BasicFuture::getMoreData);
    Future<Integer> f = future.whenComplete((v, e) -> {
      System.out.println("v:"+v);
      System.out.println("e:"+e);
    });

    System.out.println(f.get());
  }}
