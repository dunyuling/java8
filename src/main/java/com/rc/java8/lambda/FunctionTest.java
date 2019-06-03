package com.rc.java8.lambda;

import java.util.function.Function;

/**
 * @ClassName FunctionTest
 * @Description 测试Function API的基本用法
 * @Author liux
 * @Date 19-5-23 下午10:20
 * @Version 1.0
 */
public class FunctionTest {

    public static void main(String[] args) {
        Function<String, String> function = s -> {
            System.out.println("function s: " + s);
            return s.toUpperCase();
        };


        Function<String, String> before = function.compose(new Function<String, String>() {
            @Override
            public String apply(String s) {
                System.out.println("before s: " + s);

                return "before " + s;
            }
        });


        Function<String, String> before2 = before.compose(new Function<String, String>() {
            @Override
            public String apply(String s) {
                System.out.println("before2 s: " + s);
                return "before2 " + s;
            }
        });


        Function<String, String> after = function.andThen(new Function<String, String>() {
            @Override
            public String apply(String s) {
                System.out.println("after s: " + s);
                return s + " after";
            }
        });

        Function<String, String> after2 = after.andThen(new Function<String, String>() {
            @Override
            public String apply(String s) {
                System.out.println("after2 s: " + s);
                return s + " after2";
            }
        });


        String str = "hello";
        String result;

        //simple
        /*result = function.apply(str);
        System.out.println("function result: " + result);
        System.out.println("------");

        //单层组合
        result = before.apply(str);
        System.out.println("before result: " + result);
        System.out.println("------");

        result = after.apply(str);
        System.out.println("andThen result: " + result);
        System.out.println("------");

        //不同类型双层组合
        result = before.apply(after.apply(str));
        System.out.println("andThen before result: " + result);
        System.out.println("------");

        result = after.apply(before.apply(str));
        System.out.println("before andThen result: " + result);*/

        //同类型双层组合
        result = before2.apply(str);
        System.out.println("before2 result:" + result);
        System.out.println("------------");
        result = after2.apply(str);
        System.out.println("after2 result: " + result);

        System.out.println("---------");
        result = (String) Function.identity().compose(before).compose(before2).apply(str);
        System.out.println("identity result: " + result);


    }
}
