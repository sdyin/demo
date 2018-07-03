package com.sdyin.demo.test;


import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: liuye
 * @Date: 2018/6/27 20:57
 */
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

}
