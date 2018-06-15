package com.sdyin.demo.redisLock3;

/**
 * @Author: liuye
 * @Date: 2018/6/15 20:30
 */
public class ThreadA extends Thread {
  private Service service;

  public ThreadA(Service service) {
    this.service = service;
  }

  @Override
  public void run() {
    service.seckill();
  }
}

