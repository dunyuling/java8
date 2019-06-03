package com.rc.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @ClassName StreamTest
 * @Description IntStream 简单实例
 * @Author liux
 * @Date 19-5-25 上午1:44
 * @Version 1.0
 */
public class StreamTest2 {

    public static void main(String[] args) {

//        IntStream.of(1, 2, 3).forEachOrdered(value -> System.out.println("value: " + value));
//        IntStream.of(1, 2, 3).forEach(System.out::println);


        //并行 57667, 57362
        //串行 41558, 42650,42651
        /*long begin = System.currentTimeMillis();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < Math.pow(10, 7); i++) {
            list.add(i + 1);
        }
        list.forEach(System.out::println);
        System.out.println("duration: " + (System.currentTimeMillis() - begin));*/

        //并行 61233, 63861, 65274
        //串行 73694, 59630, 57377
        /*long begin = System.currentTimeMillis();
        IntStream.range(1, (int) Math.pow(10, 7)).parallel().forEach(System.out::println);
        System.out.println("duration: " + (System.currentTimeMillis() - begin));*/

        System.out.println(IntStream.rangeClosed(1, 6).map(i -> 2 * i).sum());
        IntStream.rangeClosed(1, 6).map(i -> 2 * i).reduce(Integer::sum).ifPresent(System.out::println);
        System.out.println(IntStream.rangeClosed(1, 6).map(i -> 2 * i).reduce(0, Integer::sum));

    }
}
