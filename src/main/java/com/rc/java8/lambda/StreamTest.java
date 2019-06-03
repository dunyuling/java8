package com.rc.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName StreamTest
 * @Description Stream初探
 * @Author liux
 * @Date 19-5-23 下午10:27
 * @Version 1.0
 */
public class StreamTest {

    public static void main(String[] args) {
        //转换大小写的实现
        List<String> list = Arrays.asList("hello", "world");
        //1.just lambda
        List<String> list2 = new ArrayList<>();
        list.forEach(item -> list2.add(item.toUpperCase()));
        list2.forEach(System.out::println);
        System.out.println("----------");


        //2.lambda + stream
        list.stream().map(String::toUpperCase).forEach(System.out::println);
    }
}
