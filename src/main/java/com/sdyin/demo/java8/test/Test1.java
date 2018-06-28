package com.sdyin.demo.java8.test;

import com.sdyin.demo.java8.model.Person;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.toList;

/**
 * @Author: liuye
 * @Date: 2018/6/20 15:28
 */
public class Test1 {

  public static void main(String[] args) {

    Person lisa = new Person(1, "lisa", 20);
    Person mike = new Person(2, "mike", 21);
    Person lilei = new Person(3, "lilei", 22);

    List<Person> list = new ArrayList<>();
    list.add(lilei);
    list.add(mike);
    list.add(lisa);
    list.stream()
            //过滤
            .filter(person -> person.getAge() > 20)
            //分组
            //.collect(groupingBy(Person::getAge));
            //累加
            //.collect(summingInt(Person::getAge));
            //排序
            .sorted(Comparator.comparing(Person::getAge).reversed())
            .collect(toList());

    //方法引用
    list.sort(Comparator.comparing(Person::getName));
    System.out.println("list:"+list);

    // 自定义分组
    Map<String, List<Person>> maps = list.stream()
            .collect(groupingBy(person -> {
              if (person.getAge() <= 21) {
                return "young";
              } else if (person.getAge() <= 22) {
                return "mid";
              } else {
                return "old";
              }
            }));
    System.out.println("maps:"+ maps);

    //Predicate<Person> ps = list.negate();
    int [] a ={1,2,3};
    List<int[]> list2 = Arrays.asList(a);

    list2.stream()
            .map(i -> "lisa"+i);

    /*Runnable run = ()-> System.out.println("线程名:"+Thread.currentThread().getName());
    new Thread(new Runnable() {
      @Override
      public void run() {

      }
    }).start();*/
    new Thread(()-> System.out.println("线程1名:"+Thread.currentThread().getName())).start();

    System.out.println("线程2名:"+Thread.currentThread().getName());

    Calendar c = Calendar.getInstance();
    long time = c.getTimeInMillis() - System.currentTimeMillis();
    System.out.println("time:"+ time);
    System.out.println("time2:"+ (time << 10));

    int abc =123;
    Runnable r = ()-> System.out.println(abc);
    //abc =1234;

    //函数复合
    Function<Integer,Integer> f = x -> x + 2;
    Function<Integer,Integer> g = x -> x * 2;
    //Function<Integer,Integer> h = f.andThen(g);  //g(f(x))
    Function<Integer,Integer> h = f.compose(g);    //f(g(x))
    int result = h.apply(1);
    System.out.println("result:"+result);
  }
}
