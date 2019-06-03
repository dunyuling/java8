package com.rc.java8.stream2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * @ClassName StreamTest3
 * @Description Spliterator 简单示例
 * @Author liux
 * @Date 19-5-31 下午4:30
 * @Version 1.0
 */
public class StreamTest3 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c", "d");
//        list.stream().forEach(System.out::println);


        Consumer<String> action = System.out::println;
        System.out.println(action);
        Stream<String> stream = list.stream();
        Stream<String> stream2 = stream.map(item->item.toUpperCase());
        Stream<String> stream3 = stream2.filter(item->true);
        stream3.forEach(action);


    }
}
