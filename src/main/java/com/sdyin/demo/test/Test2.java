package com.sdyin.demo.test;


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


  }

}
