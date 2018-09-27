package com.sdyin.demo.test;

import com.sdyin.demo.java8.model.Person;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: liuye
 * @Date: 2018/6/15 10:47
 */
public class Test {

  public static void main(String[] args) {
    final String test = "TEST";

    System.out.println("Test");
    System.out.println(System.nanoTime());

    List<Integer> list = new ArrayList<>();
    list.add(2);
    list.add(3);
    list.add(0,0);
    System.out.println("list:"+ list.toString());
    LinkedList<Integer> list2 = new LinkedList<>();
    list2.add(4);
    list2.add(5);
    list2.push(0);
    System.out.println("list2:"+list2.toString());


  }

  private static String test2(String test) {
    Person person = new Person();
    person.setName("lisa");
    test = person.getName();
    return test;
  }
}
