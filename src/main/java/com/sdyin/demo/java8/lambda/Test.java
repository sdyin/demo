package com.sdyin.demo.java8.lambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Function;

/**
 * @author: liuye
 * @Date: 2018/12/25 10:59
 * @Description
 */
public class Test {

  public static void main(String[] args) throws IOException {

    //传递 lambda
//    String s = processFile((BufferedReader br) -> br.readLine());
//    System.out.println("s:" + s);

    String name = "";
    String name1 = "12345";
    System.out.println(validInput(name, inputStr -> inputStr.isEmpty() ? "名字不能为空":inputStr));
    System.out.println(validInput(name1, inputStr -> inputStr.length() > 3 ? "名字过长":inputStr));
  }


  //处理接口
  public static String processFile(BufferedReaderProcessor p) throws
          IOException {
    try (BufferedReader br =
                 new BufferedReader(new FileReader("data.txt"))) {
      return p.process(br);
    }
  }

  // function
  public static String validInput(String name,Function<String,String> function) {
    return function.apply(name);
  }

  /*//consume
  public static void validInput(String name,Consumer<String> function) {
    function.accept(name);
  }

  //Predicate
  public static boolean validInput(String name,Predicate<String> function) {
    return function.test(name);
  }*/

}
