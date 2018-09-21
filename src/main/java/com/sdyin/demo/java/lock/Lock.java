package com.sdyin.demo.java.lock;

/**
 * @author: liuye
 * @Date: 2018/9/21 17:53
 * @Description
 */
public class Lock {

  private boolean isLocked = false;

  public synchronized void lock() throws InterruptedException {
    System.out.println("进入加锁");
    while (isLocked){
      System.out.println("进入while 条件判断");
      wait();
    }
    isLocked = true;
  }

  public synchronized void unlock(){
    System.out.println("进入释放锁");
    isLocked = false;
    notify();
  }
}
