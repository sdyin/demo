package com.sdyin.demo.java.lock;

/**
 * @author: liuye
 * @Date: 2018/9/21 17:55
 * @Description
 */
public class Count {

  Lock lock = new Lock();
  NonLock nonLock = new NonLock();

  public void print() throws InterruptedException {
    //不可重入锁
   /* lock.lock();
    doAdd();
    lock.unlock();*/

    //可重入锁
    nonLock.lock();
    doAdd();
    nonLock.unlock();
  }

  private void doAdd() throws InterruptedException {
    System.out.println("执行 doAdd 方法");

    //不可重入锁
    /*lock.lock();
    lock.unlock();*/

    //可重入锁
    nonLock.lock();
    nonLock.unlock();
  }

  public static void main(String[] args) throws InterruptedException {
    System.out.println("演示锁");
    System.out.println("执行main 函数");
    Count count = new Count();
    count.print();

    System.out.println("执行main函数结束");
  }

}
