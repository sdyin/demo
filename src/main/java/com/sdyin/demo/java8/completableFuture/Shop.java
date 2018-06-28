package com.sdyin.demo.java8.completableFuture;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * @Author: liuye
 * @Date: 2018/6/26 14:20
 */
public class Shop {

  private String name;

  public Shop(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public static void delay() {
    try {
      Thread.sleep(1000L);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  public double getPrice(String product) {
    return calculatePrice(product);
  }
  private double calculatePrice(String product) {
    delay();
    return Math.random() * product.charAt(0) + product.charAt(1);
  }

  public Future<Double> getPriceAsync(String product) {
    CompletableFuture<Double> futurePrice = new CompletableFuture<>();
    new Thread( () -> {
      double price = calculatePrice(product);
      futurePrice.complete(price);
    }).start();
    return futurePrice;
  }
}
