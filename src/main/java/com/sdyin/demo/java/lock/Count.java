package com.sdyin.demo.java.lock;

/**
 * 演示不可重入锁
 * @author: liuye
 * @Date: 2018/9/21 17:55
 * @Description
 */
public class Count {

  Lock lock = new Lock();

  public void print() throws InterruptedException {
    lock.lock();
    doAdd();
    lock.unlock();
  }

  private void doAdd() throws InterruptedException {
    System.out.println("执行 doAdd 方法");
    lock.lock();

    lock.unlock();
  }

  public static void main(String[] args) throws InterruptedException {
    System.out.println("演示不可重入锁");
    System.out.println("执行main 函数");
    Count count = new Count();
    count.print();

    System.out.println("执行main函数结束");
  }

}
