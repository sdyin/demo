package com.sdyin.demo.future.completeFuture;

import java.util.concurrent.*;

/**
 * @author: liuye
 * @Date: 2018/8/20 21:52
 * @Description
 */
public class Test1 {

  public static void main(String[] args) {

    Double d1 = 2.3;
    Future<Double> priceAsyn = getPriceAsyn(d1);
    Double aDouble = null;
    try {
      aDouble = priceAsyn.get(50, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (ExecutionException e) {
      e.printStackTrace();
    } catch (TimeoutException e) {
      e.printStackTrace();
    }
    System.out.println(aDouble);

  }

  /**
   * 异步计算
   * @return
   */
  public static Future<Double> getPriceAsyn(Double d1){
    /* 方式一:
    ExecutorService executorService = Executors.newFixedThreadPool(4);
    CompletableFuture comFuture = new CompletableFuture<>();
    Callable c = () -> {
      Double aDouble = calculatePrice(d1);
      comFuture.complete(aDouble);
      return comFuture;
    };
    executorService.submit(c);
    return comFuture;*/
    //方式二
    CompletableFuture<Double> comFuture = null;
    try {
      comFuture = CompletableFuture.supplyAsync(() -> calculatePrice(d1));
    } catch (Exception e) {
      comFuture.completeExceptionally(e);
    }
    //Double join = comFuture.join();
    return comFuture;
  }

  /**  
   * @author liuye
   * @date 2018/8/21 10:12
   * @param d1
   * @return java.lang.Double
   */
  private static Double calculatePrice(Double d1) {
    d1 = d1 * 1.2;
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return d1;
  }
}
