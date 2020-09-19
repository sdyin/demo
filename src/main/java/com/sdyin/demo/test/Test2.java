package com.sdyin.demo.test;


import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: liuye
 * @Date: 2018/6/27 20:57
 */
//@Configuration
@EnableAsync
@Component
public class Test2 {

  public static void main(String[] args) {

    String str = "\t";
    Pattern p = Pattern.compile("\\s*|\t|\r|\n");
    Matcher matcher = p.matcher(str);
    String s = matcher.replaceAll("");
    if("".equals(s.trim())){
      System.out.println("空串:"+"true");
    }else{
      System.out.println("空串:"+"false");
    }
    List list = new ArrayList();
    list.add(1);
    list.add(2);
    list.add(3);
    Object[] objects = list.stream()
            .map(item -> Long.valueOf(item.toString()))
            .toArray(Long[]::new);
    /*Object[] longs = list.toArray();
    Long aLong = Long.valueOf(longs.toString());*/
    System.out.println("long:"+objects);
  }

  @Async
  public void test2() throws Exception {
    int a = 10;
    for (a = 0;a<10;a++){
      Thread.sleep(500);
      System.out.println("a:"+a+" "+ Thread.currentThread().getName());
    }
  }

}
