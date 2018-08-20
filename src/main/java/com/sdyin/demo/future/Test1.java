package com.sdyin.demo.future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author: liuye
 * @Date: 2018/8/20 21:50
 * @Description
 */
public class Test1 {

  public static void main(String[] args) {

    List list = new ArrayList<Integer>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);

    ExecutorService pool = Executors.newFixedThreadPool(4);

    //
    ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(4, 10, 10,
            TimeUnit.MINUTES, new ArrayBlockingQueue(10));

    Callable c1 = ()->{
      Integer r1 = (Integer)list.stream()
              .reduce(0, (a, b) -> (Integer) a + (Integer) b);
      System.out.println("sum:"+r1);
      return r1;
    };

    Callable c2 = ()->{
      Integer r2 = (Integer)list.stream()
              .reduce(1, (a, b) -> (Integer)a * (Integer)b);
      System.out.println("product:" + r2);
      return r2;
    };

    Future f1 = poolExecutor.submit(c1);
    Future f2 = poolExecutor.submit(c2);
    /*poolExecutor.submit(Callable c3 = ()->{

    });*/

    if(f1.isDone() && f2.isDone()){
      try {
        Integer o1 = null;
        o1 = (Integer)f1.get(30, TimeUnit.SECONDS);

        Integer o2 = (Integer)f2.get(30,TimeUnit.SECONDS);
        System.out.println("o1:"+ o1 + " o2:" + o2);
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (ExecutionException e) {
        e.printStackTrace();
      }catch (TimeoutException e) {
        e.printStackTrace();
      }
    }

  }
}
