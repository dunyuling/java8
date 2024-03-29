package com.rc.java8.lambda;

/**
 * @ClassName Person
 * @Description Person pojo
 * @Author liux
 * @Date 19-5-24 上午11:48
 * @Version 1.0
 */
public class Person {

    private String name ="张三";

    private int age = 10;

    public Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static Person get() {
        return new Person();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
