package com.sdyin.demo.java.lock;

/**
 * 可重入锁
 * @author: liuye
 * @Date: 2018/9/21 18:43
 * @Description
 */
public class NonLock {

  boolean isLocked = false;
  Thread  lockedBy = null;
  int lockedCount = 0;

  public synchronized void lock()
          throws InterruptedException{
    System.out.println("进入可重入锁 加锁");
    Thread thread = Thread.currentThread();
    while(isLocked && lockedBy != thread){
      wait();
    }
    isLocked = true;
    lockedCount++;
    lockedBy = thread;
  }

  public synchronized void unlock(){
    System.out.println("进入可重入锁 释放锁");
    if(Thread.currentThread() == this.lockedBy){
      lockedCount--;
      if(lockedCount == 0){
        isLocked = false;
        notify();
      }
    }
  }
}
