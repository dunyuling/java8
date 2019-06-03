package com.rc.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName StreamTest7
 * @Description 串行流与并行流测试---并行不一定快
 * @Author liux
 * @Date 19-5-26 上午12:36
 * @Version 1.0
 */
public class StreamTest7 {

    public static void main(String[] args) {
//        test1();
        test2();
    }

    //并行快
    private static void test1() {
        int size = 5000000;
        List<String> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(UUID.randomUUID().toString());
        }
        System.out.println("串行流开始:");
        long begin = System.nanoTime();
        list.stream().sorted().count();
        long end = System.nanoTime();
        System.out.println("串行流结束: " + TimeUnit.NANOSECONDS.toMillis(end - begin));
        System.out.println("----------");

        System.out.println("并行流开始:");
        begin = System.nanoTime();
        list.parallelStream().sorted().count();
        end = System.nanoTime();
        System.out.println("并行流结束: " + TimeUnit.NANOSECONDS.toMillis(end - begin));
    }

    //并行慢
    private static void test2() {
        //并行 57667, 57362
        //串行 41558, 42650,42651

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < Math.pow(10, 7); i++) {
            list.add(i + 1);
        }
        long begin = System.currentTimeMillis();
        list
//                .stream().parallel()
//                .stream()
                .parallelStream()
//                .forEach(System.out::println);

            .count();
        System.out.println("duration: " + (System.currentTimeMillis() - begin));

        //并行 61233, 63861, 65274
        //串行 73694, 59630, 57377
        /*long begin = System.currentTimeMillis();
        IntStream.range(1, (int) Math.pow(10, 7)).parallel().forEach(System.out::println);
        System.out.println("duration: " + (System.currentTimeMillis() - begin));*/
    }
}
