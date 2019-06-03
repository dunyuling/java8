package com.rc.java8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * @ClassName PersonTest
 * @Description 对象流 简单实例
 * @Author liux
 * @Date 19-5-24 上午11:50
 * @Version 1.0
 */
public class PersonTest {

    public static void main(String[] args) {
        Person p1 = new Person("zhangsan", 10);
        Person p2 = new Person("lisi", 20);
        Person p3 = new Person("wangwu", 30);
        Person p4 = new Person("maliu", 40);

        List<Person> personList = Arrays.asList(p1, p2, p3, p4);

        getPersonByUsername("zhangsan", personList).forEach(System.out::println);
        System.out.println("-----------");
        getPersonByAge(10, personList).forEach(System.out::println);
        System.out.println("-------------");
        BiFunction<Integer, List<Person>, List<Person>> biFunction =
                (tempAge, list) -> list.stream().filter(person -> person.getAge() > tempAge)
                        .collect(Collectors.toList());
        getPersonByAge2(20, personList, biFunction).forEach(System.out::println);
        System.out.println("------------");
        getPersonByAge3(30, personList).forEach(System.out::println);
    }

    private static List<Person> getPersonByUsername(String username, List<Person> personList) {
        return personList.stream()
                .filter(person -> person.getName().equals(username))
                .collect(Collectors.toList());
    }

    private static List<Person> getPersonByAge(int age, List<Person> personList) {
        BiFunction<Integer, List<Person>, List<Person>> biFunction =
                (tempAge, list) -> list.stream().filter(person -> person.getAge() > tempAge)
                        .collect(Collectors.toList());
        return biFunction.apply(age, personList);
    }

    //最灵活
    private static List<Person> getPersonByAge2(int age, List<Person> personList,
                                                BiFunction<Integer, List<Person>, List<Person>> biFunction) {
        return biFunction.apply(age, personList);
    }

    private static List<Person> getPersonByAge3(int age, List<Person> personList) {
        return personList.stream()
                .filter(person -> person.getAge() > age)
                .collect(Collectors.toList());
    }
}
