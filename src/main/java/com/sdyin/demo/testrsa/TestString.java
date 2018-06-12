package com.sdyin.demo.testrsa;

/**
 * @Author: liuye
 * @Date: 2018/6/7 15:35
 */
public class TestString {

  public static void main(String[] args) {
    String str = "qwertyuiop123";
    System.out.println(str.concat("wer"));
    // String 转 byte 数组
    byte[] wers = str.concat("wer").getBytes();
    System.out.println(str.concat("wer").getBytes());
    // byte 数组转 String
    String s = new String(wers);
    System.out.println(s);
  }

}
