package com.sdyin.demo.java.condition;

/**
 * @author: liuye
 * @Date: 2018/9/22 11:29
 * @Description
 */
public class ThreadTest2 {

  public static void main(String[] args) {
    final Business business = new Business();
    new Thread(new Runnable() {
      @Override
      public void run() {
        threadExecute(business, "sub");
      }
    }).start();
    threadExecute(business, "main");
  }
  public static void threadExecute(Business business, String threadType) {
    for(int i = 0; i < 100; i++) {
      try {
        if("main".equals(threadType)) {
          business.main(i);
        } else {
          business.sub(i);
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

}
