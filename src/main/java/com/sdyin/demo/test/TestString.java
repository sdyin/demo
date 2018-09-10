package com.sdyin.demo.test;

/**
 * @author: liuye
 * @Date: 2018/9/10 13:45
 * @Description
 */
public class TestString {

  public static void main(String[] args) {
    String a = "a";
    String b = "b";
    String ab1 = "a"+"b";
    String ab2 ="ab";
    String ab3 = a+b;
    //true
    System.out.println(ab1 == ab2);
    //false
    System.out.println(ab1 == ab3);
    //false
    System.out.println(ab2 == ab3);
  }
}
