package com.sdyin.demo.utils;

/**
 * 计算工具类
 * @author: liuye
 * @Date: 2018/12/6 14:06
 * @Description
 */
public class ComputeUtil {

  /**
   * 计算方差,标准差
   * @param args
   */
  public static void main(String[] args) {
    int[] array = {15,96,85,88,18,58,68,16,6,99,88,11,8,36,82,44,55,66};
    int sum = 0;
    for(int i=0;i<array.length;i++){
      //求出数组的总和
      sum += array[i];
    }
    //939
    System.out.println(sum);
    //求出数组的平均数
    double average = sum/array.length;
    //52.0
    System.out.println(average);
    int total=0;
    for(int i=0;i<array.length;i++){
      //求出方差，如果要计算方差的话这一步就可以了
      total += (array[i]-average)*(array[i]-average);
    }
    //求出标准差
    double standardDeviation = Math.sqrt(total/array.length);
    //32.55764119219941
    System.out.println(standardDeviation);
  }

}
