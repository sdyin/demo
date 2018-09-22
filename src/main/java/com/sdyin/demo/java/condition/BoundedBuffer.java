package com.sdyin.demo.java.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: liuye
 * @Date: 2018/9/22 11:31
 * @Description
 */
public class BoundedBuffer {

      //锁对象
    final Lock lock = new ReentrantLock();
      //写线程条件
    final Condition notFull = lock.newCondition();
    //读线程条件
    final Condition notEmpty = lock.newCondition();
    //缓存队列
    final Object[] items = new Object[100];
    /*写索引*/
    int putptr,
    /*读索引*/
    takeptr,
    /*队列中存在的数据个数*/
    count;

    public void put(Object x) throws InterruptedException {
      lock.lock();
      try {
        //如果队列满了
        while (count == items.length){
          //阻塞写线程
          notFull.await();
        }
        //赋值
        items[putptr] = x;
        if (++putptr == items.length){
          //如果写索引写到队列的最后一个位置了，那么置为0
          putptr = 0;
        }
          ++count;//个数++
          notEmpty.signal();//唤醒读线程
        } finally {
          lock.unlock();
        }
    }

    public Object take() throws InterruptedException {
      lock.lock();
      try {
        //如果队列为空
        while (count == 0) {
          //阻塞读线程
          notEmpty.await();
        }
        //取值
        Object x = items[takeptr];
        //如果读索引读到队列的最后一个位置了，那么置为0
        if (++takeptr == items.length) {
          takeptr = 0;
        }
        --count;//个数--
        notFull.signal();//唤醒写线程
        return x;
      } finally {
        lock.unlock();
      }
    }



}
