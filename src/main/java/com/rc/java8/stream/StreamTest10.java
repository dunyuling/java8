package com.rc.java8.stream;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName StreamTest10
 * @Description flatmap 再应用
 * @Author liux
 * @Date 19-5-26 上午9:56
 * @Version 1.0
 */
public class StreamTest10 {

    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("hello", "hi", "你好");
        List<String> list2 = Arrays.asList("zhangsan", "lisi", "wangwu", "maliu");

        //嵌套流方式不好
        /*list1.stream().peek(new Consumer<String>() {
            @Override
            public void accept(String s) {
                list2.forEach(new Consumer<String>() {
                    @Override
                    public void accept(String s1) {
                        System.out.println(s + " " + s1);
                    }
                });
            }
        }).forEach(s -> System.out.println("------------ " + s));*/

        list1.stream().flatMap(s-> list2.stream().map(s1->s+" " + s1)).forEach(System.out::println);

//        test1();
    }




}
