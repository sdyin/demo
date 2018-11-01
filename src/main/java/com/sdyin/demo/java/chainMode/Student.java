package com.sdyin.demo.java.chainMode;

import lombok.Data;

/**
 * @author: liuye
 * @Date: 2018/11/1 16:26
 * @Description
 */
@Data
public class Student {

  private int id ;
  private String name;
  private int age;
  private String gender;
  private int score;


  public static Builder builder(){
    return new Builder();
  }

  public static class Builder{

    private int id ;
    private String name;
    private int age;
    private String gender;
    private int score;

    public Student create(){
      Student student = new Student();
      student.setScore(this.score);
      student.setId(this.id);
      student.setGender(this.gender);
      student.setAge(this.age);
      student.setName(this.name);
      return student;
    }

    public Builder setId(int id){
      this.id = id;
      return this;
    }

    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public Builder setAge(int age) {
      this.age = age;
      return this;
    }

    public Builder setGender(String gender) {
      this.gender = gender;
      return this;
    }

    public Builder setScore(int score) {
      this.score = score;
      return this;
    }
  }

}
