package com.rc.java8.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName StringComparator
 * @Description 字符串排序
 * @Author liux
 * @Date 19-5-23 下午10:28
 * @Version 1.0
 */
public class StringComparator {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("zhangsan", "lisi", "wangwu", "maliu");
        Collections.sort(names, Comparator.reverseOrder());
        names.forEach(System.out::println);
    }
}
