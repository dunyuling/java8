package com.rc.java8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * @ClassName SupplierTest
 * @Description Supplier 简单实例
 * @Author liux
 * @Date 19-5-24 下午4:13
 * @Version 1.0
 */
public class SupplierTest {

    public static void main(String[] args) {
        Supplier<String> supplier = () -> "hello supplier";
        System.out.println(supplier.get());
        System.out.println("-------------");

        Supplier<Person> supplier1 = () -> new Person("xiaoming",20);
        System.out.println(supplier1.get());
        System.out.println("-------------");

//        Supplier<Person> supplier2 = Person::new;
        Supplier<Person> supplier2 = Person::get;
        System.out.println(supplier2.get());
        System.out.println("-------------");

        Supplier<List<Person>> supplier3 = () -> Arrays.asList(new Person("xiaoming",20),
                new Person("xiaozhang",30));
        supplier3.get().forEach(System.out::println);
        System.out.println("-------------");
    }
}
