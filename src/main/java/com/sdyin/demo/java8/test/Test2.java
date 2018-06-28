package com.sdyin.demo.java8.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Author: liuye
 * @Date: 2018/6/22 14:46
 */
public class Test2 {
  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
    List<Integer> collect = list.stream()
            .map(item -> item * item)
            .collect(Collectors.toList());

    Optional<Integer> result = list.stream()
            .reduce((a, b) -> a * b);
    System.out.println("result:" + result);

    list.stream()
            .reduce(0,Integer::sum);
  }
}