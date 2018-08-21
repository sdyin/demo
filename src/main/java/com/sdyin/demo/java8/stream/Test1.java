package com.sdyin.demo.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors.*;

import static java.util.stream.Collectors.toList;

/**
 * @author: liuye
 * @Date: 2018/8/21 17:13
 * @Description
 */
public class Test1 {

  public static void main(String[] args) {
    Student lisa = new Student(1, "lisa", 21);
    Student mike = new Student(1, "mike", 22);
    Student sdyin = new Student(1, "sdyin", 23);
    Student lilei = new Student(1, "lilei", 24);
    Student hanmeimei = new Student(1, "hanmeimei", 24);
    List<Student> stus = new ArrayList<>();
    stus.add(lisa);
    stus.add(mike);
    stus.add(sdyin);
    stus.add(lilei);
    stus.add(hanmeimei);


    stus.stream()
            .filter(stu-> {
              System.out.println("filter:"+stu.getName());
              return stu.getAge()>20;
            })
            .map(stu->{
              System.out.println("map:"+ stu.getName());
              return stu.getName();
            })
            .limit(3)
            .collect(toList());

    System.out.println("--------------------------");

    stus.parallelStream()
            .filter(stu-> {
                    System.out.println("filter:"+stu.getName());
                    return stu.getAge()>21;
            })
            .map(stu->{
              System.out.println("map:"+ stu.getName());
              return stu.getName();
            })
            .limit(3)
            .collect(toList());
  }
}
