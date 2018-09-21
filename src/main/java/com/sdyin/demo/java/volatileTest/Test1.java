package com.sdyin.demo.java.volatileTest;

/**
 * @author: liuye
 * @Date: 2018/9/21 14:54
 * @Description
 */
public class Test1 extends Thread{

  private volatile boolean stop = false;

  public void stopMe(){
    System.out.println("准备关闭");
    stop = true;
  }

  @Override
  public void run(){
    int i = 0;
    while (!stop){
      i++;
      System.out.println("i:"+i);
    }
    System.out.println("stop Thread");
  }

  public static void main(String[] args) throws InterruptedException {
    Test1 test1 = new Test1();
    test1.start();
    Thread.sleep(1000);
    test1.stopMe();
  }
}
