package com.sdyin.demo.java.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: liuye
 * @Date: 2018/9/22 11:30
 * @Description
 */
public class Business {

  private boolean bool = true;
  private Lock lock = new ReentrantLock();
  private Condition condition = lock.newCondition();
  public /*synchronized*/ void main(int loop) throws InterruptedException {
    lock.lock();
    try {
      while(bool) {
        condition.await();//this.wait();
      }
      for(int i = 0; i < 100; i++) {
        System.out.println("main thread seq of " + i + ", loop of " + loop);
      }
      bool = true;
      condition.signal();//this.notify();
    } finally {
      lock.unlock();
    }
  }
  public /*synchronized*/ void sub(int loop) throws InterruptedException {
    lock.lock();
    try {
      while(!bool) {
        condition.await();//this.wait();
      }
      for(int i = 0; i < 10; i++) {
        System.out.println("sub thread seq of " + i + ", loop of " + loop);
      }
      bool = false;
      condition.signal();//this.notify();
    } finally {
      lock.unlock();
    }
  }

}
