package com.sdyin.demo.redisLock3;

/**
 * @Author: liuye
 * @Date: 2018/6/15 20:31
 */
public class Test {
  public static void main(String[] args) {
    Service service = new Service();
    for (int i = 0; i < 50; i++) {
      ThreadA threadA = new ThreadA(service);
      threadA.start();
    }
  }
}
