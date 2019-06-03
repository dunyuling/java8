package com.rc.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @ClassName Test3
 * @Description Lambda for loop
 * @Author liux
 * @Date 19-5-23 下午3:56
 * @Version 1.0
 */
public class Test3 {

    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);//Arrays's forEach
        List<Integer> list = new ArrayList<>();//ArrayList's forEach
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Consumer<Integer> consumer = System.out::println;
        list.forEach(consumer);
//        System.out.println(consumer);
    }
}
