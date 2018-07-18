package com.sdyin.demo.test;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * @Author: liuye
 * @Date: 2018/7/10 15:41
 */
public class Test3 {
  public static void main(String[] args) {
    DecimalFormat df = new DecimalFormat("0.0");
    int number = 99900;
    float f = (float)number/10000;
    System.out.println(f);
    df.setRoundingMode(RoundingMode.DOWN);
    String s = df.format(f);
    System.out.println(s);
  }
}
