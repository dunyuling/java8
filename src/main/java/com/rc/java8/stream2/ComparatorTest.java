package com.rc.java8.stream2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.ToIntFunction;

/**
 * @ClassName ComparatorTest
 * @Description Comparator 简单实例
 * @Author liux
 * @Date 19-5-27 下午6:05
 * @Version 1.0
 */
public class ComparatorTest {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("ab", "f", "c", "de");
//        Collections.sort(list, (o1, o2) -> o1.length() - o2.length());
//        强制类型转换 1
//        Collections.sort(list, Comparator.comparingInt((ToIntFunction<String>) value -> value.length()).reversed());
//        强制类型转换 2
//        Collections.sort(list, Comparator.comparingInt((String item) -> item.length()).reversed());

//        Collections.sort(list, Comparator.comparingInt(item -> item.length()));

        list.sort(Comparator.comparingInt(String::length).thenComparing(String.CASE_INSENSITIVE_ORDER));
        System.out.println(list);
        list.sort(Comparator.comparingInt(String::length).thenComparing(String::toLowerCase, Comparator.reverseOrder()));
        System.out.println(list);
        list.sort(Comparator.comparingInt(String::length)
                .thenComparing(String::toLowerCase, Comparator.reverseOrder())
                .thenComparing(Comparator.reverseOrder()));//无作用
        System.out.println(list);

        list = Arrays.asList("f", "c", "de", "ab");
        list.sort(Comparator.reverseOrder());
        System.out.println(list);
    }
}
