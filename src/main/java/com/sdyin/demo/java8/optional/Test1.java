package com.sdyin.demo.java8.optional;

import com.sdyin.demo.java8.optional.entity.Car;
import com.sdyin.demo.java8.optional.entity.Insurance;
import com.sdyin.demo.java8.optional.entity.Person;

import java.util.Optional;

/**
 * @Author: liuye
 * @Date: 2018/6/26 11:15
 */
public class Test1 {
  public static void main(String[] args) {

    Person person = new Person();
    //person = null;
    Optional<Person> optPerson = Optional.of(person);

    String name = optPerson.map(Person::getCar)
            .map(Car::getInsurance)
            .map(Insurance::getName)
            .orElse("default");
    // default
    System.out.println("name:"+ name);

    //String name1 = person.getCar().getInsurance().getName();
    //NullPointException
    //System.out.println("name1:"+ name1);

    Optional<String> name2 =
            optPerson.map(Person::getCar)
                    .map(Car::getInsurance)
                    .map(Insurance::getName);
    System.out.println("name2:" + name2);
  }
}
