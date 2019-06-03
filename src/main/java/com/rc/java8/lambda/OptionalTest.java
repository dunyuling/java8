package com.rc.java8.lambda;

import java.util.Optional;

/**
 * @ClassName OptionalTest
 * @Description Optional 简单实例
 * @Author liux
 * @Date 19-5-24 下午6:08
 * @Version 1.0
 */
public class OptionalTest {

    public static void main(String[] args) {
        Optional<String> optional = Optional.of("hello");
        optional.ifPresent(System.out::println);
        System.out.println("-----------");

        Optional<String> optional2 = Optional.empty();
        optional2.ifPresent(System.out::println);
        System.out.println("-----------");


        Optional<String> optional3 = Optional.empty();
        System.out.println(optional3.orElse("world"));
        System.out.println("-----------");

        Optional<String> optional4 = Optional.empty();
        System.out.println(optional4.orElseGet(() -> "你好"));
        System.out.println("-----------");


    }
}
