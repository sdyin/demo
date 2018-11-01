package com.sdyin.demo.java.chainMode;

/**
 * @author: liuye
 * @Date: 2018/11/1 16:29
 * @Description
 */
public class Test {

  public static void main(String[] args) {

    Student stu = Student.builder()
            .setId(1)
            .setName("liuye")
            .setGender("male")
            .setScore(95).create();
    System.out.println("student:"+ stu.toString());

  }
}
