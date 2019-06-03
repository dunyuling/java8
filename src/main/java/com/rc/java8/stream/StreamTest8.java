package com.rc.java8.stream;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName StreamTest8
 * @Description 通过打印输出观察流的运作机制--流存在短路操作
 * @Author liux
 * @Date 19-5-26 上午1:05
 * @Version 1.0
 */
public class StreamTest8 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "hello world");
//        list.stream().filter(s -> s.length() == 5).findFirst().ifPresent(s -> System.out.println(s + ", " + s.length()));

        list.stream().mapToInt(item-> {
            int length = item.length();
            System.out.println("item: " + item);
            return length;
        }).filter(length->length==10).findFirst().ifPresent(System.out::println);
    }
}
