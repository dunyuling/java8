package com.rc.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @ClassName StreamTest
 * @Description 构造stream对象
 * @Author liux
 * @Date 19-5-25 上午1:44
 * @Version 1.0
 */
public class StreamTest {

    public static void main(String[] args) {
        Stream stream1 = Stream.of("a", "b", "c");

        String[] arr = new String[]{"a", "b", "c"};
        Stream stream2 = Stream.of(arr);
        Stream stream3 = Arrays.stream(arr);

        List<String> list = Arrays.asList(arr);
        Stream stream4 = list.stream();
    }
}
