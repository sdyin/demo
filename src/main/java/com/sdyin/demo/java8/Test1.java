package com.sdyin.demo.java8;

import com.sdyin.demo.java8.model.Person;

import java.io.File;
import java.io.FileFilter;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: liuye
 * @Date: 2018/6/16 20:05
 */
public class Test1 {

  //private final static Comparator<Object> CHINA_COMPARE = Collator.getInstance(java.util.Locale.CHINA);

  public static void main(String[] args) {
    /*List list  = new ArrayList<String>();
    list.add("a");
    list.add("b");
    list.add("c");
    list.stream().forEach(
            item->{
              System.out.println(item);
            }
    );*/
    File[] files = new File(".").listFiles(new FileFilter() {
      @Override
      public boolean accept(File file) {
        return file.isHidden();
      }
    });
    System.out.println(files);

    File[] files1 = new File(".").listFiles(File::isHidden);
    System.out.println(files1);

    Person person = new Person(1,"小明",20);
//    System.out.println(Person::getName);
    Person person2 = new Person(2,"张明",20);
    Person person3 = new Person(2,"陈明",20);
    List<String> lists = new ArrayList<>();
    lists.add("小明");
    lists.add("张明");
    lists.add("陈明");
    lists.add("所以");
    lists.add("wo");

    System.out.println(lists);
    Collections.sort(lists, Collator.getInstance(java.util.Locale.CHINA));
    //lists.stream().sorted();
    System.out.println(lists);

  }
}
