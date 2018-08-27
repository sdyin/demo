package com.sdyin.demo.limitRate;

import com.google.common.util.concurrent.RateLimiter;

/**
 * 限流算法:令牌算法
 * @author: liuye
 * @Date: 2018/8/27 20:15
 * @Description
 */
public class Test1 {

  public static void main(String[] args) {

    //令牌桶每秒钟产生两个令牌
    RateLimiter rateLimiter = RateLimiter.create(2);
    System.out.println("是否可执行:"+rateLimiter.tryAcquire());
    System.out.println(rateLimiter.acquire(5));
    System.out.println("是否可执行:"+rateLimiter.tryAcquire());
    System.out.println(rateLimiter.acquire(2));
    System.out.println("是否可执行:"+rateLimiter.tryAcquire());
    System.out.println(rateLimiter.acquire(1));



  }
}
