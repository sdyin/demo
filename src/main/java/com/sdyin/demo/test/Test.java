package com.sdyin.demo.test;

import com.sdyin.demo.java8.model.Person;

/**
 * @Author: liuye
 * @Date: 2018/6/15 10:47
 */
public class Test {

  public static void main(String[] args) {
    final String test = "TEST";

    System.out.println("Test");
    System.out.println(System.nanoTime());
  }

  private static String test2(String test) {
    Person person = new Person();
    person.setName("lisa");
    test = person.getName();
    return test;
  }
}
