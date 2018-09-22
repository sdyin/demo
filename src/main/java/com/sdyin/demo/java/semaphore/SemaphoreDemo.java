package com.sdyin.demo.java.semaphore;

import java.util.concurrent.Semaphore;

/**
 * 模拟学校食堂的窗口打饭过程
 学校食堂有2个打饭窗口
 学校中午有20个学生 按次序 排队打饭
 每个人打饭时耗费时间不一样
 有的学生耐心很好，他们会一直等待直到打到饭
 有的学生耐心不好，他们等待时间超过了心里预期，就不再排队，而是回宿舍吃泡面了
 有的学生耐心很好，但是突然接到通知，说是全班聚餐，所以也不用再排队，而是去吃大餐了

 食堂有2个打饭窗口：需要定义一个permits=2的Semaphore对象。
 学生 按次序 排队打饭：此Semaphore对象是公平的。
 有20个学生：定义20个学生线程。
 打到饭的学生：调用了acquireUninterruptibly()方法，无法被中断
 吃泡面的学生：调用了tryAcquire(timeout,TimeUnit)方法，并且等待时间超时了
 吃大餐的学生：调用了acquire()方法，并且被中断了

 * @author: liuye
 * @Date: 2018/9/22 14:45
 * @Description
 */
public class SemaphoreDemo {

  /**
   * 打饭窗口
   * 2：   2个打饭窗口
   * true：公平队列-FIFO
   */
  static Semaphore semaphore = new Semaphore(2, true);

}
