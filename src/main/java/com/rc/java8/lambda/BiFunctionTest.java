package com.rc.java8.lambda;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @ClassName BiFunctionTest
 * @Description BiFunction 简单用例
 * @Author liux
 * @Date 19-5-24 上午10:40
 * @Version 1.0
 */
public class BiFunctionTest {

    public static void main(String[] args) {
        //基本用法
//        test();

        //+,-,*,/ 归为一个方法
/*        int plusResult = compute(1, 2, (v1, v2) -> v1 + v2);
        int minusResult = compute(1, 2, (v1, v2) -> v1 - v2);
        int multiResult = compute(1, 4, (v1, v2) -> v1 * v2);
        int divideResult = compute(6, 2, (v1, v2) -> v1 / v2);
        System.out.println("plusResult: " + plusResult + ", minusResult: " + minusResult +
                ", multiResult:" + multiResult + ", divideResult:" + divideResult);
        System.out.println("------------");*/

        //andThen
        System.out.println(compute2(3, 4, (v1, v2) -> v1 * v2, v1 -> v1 * v1));

    }

    private static void test() {
        BiFunction<String, String, String> biFunction = (s, s2) -> {
            System.out.println("biFunction: s1: " + s + ", s2: " + s2);
            return s + s2;
        };

        BiFunction<String, String, String> after = biFunction.andThen(s -> {
            System.out.println("'after: s': " + s);
            return s + " after";
        });

        String s = "hello", s2 = " lambda";
        String result;
        result = biFunction.apply(s, s2);
        System.out.println("biFunction result: " + result);
        System.out.println("---------");
        result = after.apply(s, s2);
        System.out.println("after result: " + result);
    }

    private static Integer compute(int a, int b, BiFunction<Integer, Integer, Integer> biFunction) {
        return biFunction.apply(a, b);
    }

    private static Integer compute2(int a, int b,
                                    BiFunction<Integer, Integer, Integer> biFunction,
                                    Function<Integer, Integer> after) {
        return after.apply(biFunction.apply(a, b));
    }
}
