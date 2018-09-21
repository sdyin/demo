package com.sdyin.demo.java.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * BlockQueue 队列模拟
 * @author: liuye
 * @Date: 2018/9/21 17:29
 * @Description
 */
public class BlockQueueTest {

  private List list = new ArrayList<>();

  public synchronized Object pop() throws InterruptedException {
    while(list.size() == 0){
      this.wait();
    }
    if(list.size() > 0){
      return list.remove(0);
    }else{
      return null;
    }
  }

  public synchronized void put(Object o){
    list.add(o);
    this.notify();
  }
}
