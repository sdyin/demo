package com.sdyin.demo.java8.completableFuture;

import java.util.concurrent.*;

/**
 * @author: liuye
 * @Date: 2018/8/22 14:14
 * @Description
 */
public class Test2 {


  public static void main(String[] args) {

    Executor executor = Executors.newFixedThreadPool(4, new ThreadFactory() {
      @Override
      public Thread newThread(Runnable r) {
        Thread t = new Thread();
        //使用守护线程方式  这种方式不会阻止线程中断
        t.setDaemon(true);
        return t;
      }
    });

    //阿里线程推荐创建方式
    ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(4, 20, 2, TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>(1024), new ThreadPoolExecutor.AbortPolicy());

    poolExecutor.execute(()->{});
    poolExecutor.submit(()->{});
  }
}
