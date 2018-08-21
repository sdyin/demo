package com.sdyin.demo.java8.stream;


import lombok.Data;

/**
 * @author: liuye
 * @Date: 2018/8/21 17:23
 * @Description
 */
@Data
public class Student {

  private int id;

  private String name;

  private int age;

  public Student(int id, String name, int age) {
    this.id = id;
    this.name = name;
    this.age = age;
  }

}
