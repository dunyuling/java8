package com.rc.java8.stream;

import java.util.stream.IntStream;

/**
 * @ClassName StreamTest6
 * @Description Stream 操作可能遇到的坑
 * @Author liux
 * @Date 19-5-25 下午11:41
 * @Version 1.0
 */
public class StreamTest6 {

    public static void main(String[] args) {
        cannotClose();
    }

    private static void cannotClose() {
        //无法关闭,因为不可能达到四个元素
//        IntStream.iterate(0,i->(i+1)%2).distinct().limit(4).forEach(System.out::println);
        //正确写法
        IntStream.iterate(0, i -> (i + 1) % 2).limit(4).distinct().forEach(System.out::println);

    }


}
