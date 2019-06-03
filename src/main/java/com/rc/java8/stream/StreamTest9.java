package com.rc.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName StreamTest9
 * @Description flatMap 再应用,通过打印输出观察流的运作机制
 * @Author liux
 * @Date 19-5-26 上午1:21
 * @Version 1.0
 */
public class StreamTest9 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello world", "world hello",
                "welcome hello", "welcome world");

        //方法一
        /*list.stream().flatMap(item -> {
            String[] arr = item.split(" +");
            for (String str : arr) {
                System.out.println("str: " + str + "  ----");
            }
            return Stream.of(arr);
        }).distinct().forEach(System.out::println);*/

        //方法二
        list.stream().map(item -> {
            String[] arr = item.split(" +");
            for (String str : arr) {
                System.out.println("str: " + str + "  ----");
            }
            return arr;
        })
//                .flatMap(Stream::of)  //以Stream为主体
                .flatMap(Arrays::stream)//以Arrays为主体
                .distinct().forEach(System.out::println);

    }
}
