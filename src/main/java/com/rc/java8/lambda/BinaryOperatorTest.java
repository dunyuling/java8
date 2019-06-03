package com.rc.java8.lambda;

import java.util.Comparator;
import java.util.function.BinaryOperator;

/**
 * @ClassName BinaryOperatorTest
 * @Description BinaryOperator 简单实例
 * @Author liux
 * @Date 19-5-24 下午4:42
 * @Version 1.0
 */
public class BinaryOperatorTest {

    public static void main(String[] args) {
        System.out.println("8+3: " + (computer(8, 3, (a, b) -> a + b)));
        System.out.println("8-3: " + (computer(8, 3, (a, b) -> a - b)));
        System.out.println("8*3: " + (computer(8, 3, (a, b) -> a * b)));
        System.out.println("8/3: " + (computer(8, 3, (a, b) -> a / b)));
        System.out.println("------------");

        BinaryOperator<Integer> binaryOperator = (integer, integer2) -> null;
        System.out.println(computer(4, 5, binaryOperator));
        System.out.println("------------");

        BinaryOperator<Integer> binaryOperator1 = BinaryOperator.maxBy(Comparator.comparingInt(o -> o));
        int result = binaryOperator1.apply(1, 2);
        System.out.println("result: " + result);
        System.out.println("------------");

        BinaryOperator<Integer> binaryOperator2 = BinaryOperator.minBy(((o1, o2) -> o1 - o2));
        result = binaryOperator2.apply(1, 2);
        System.out.println("result: " + result);
        System.out.println("------------");

        System.out.println("min:(hello!,world):  " + getMin("hello!", "world", (o1, o2) -> o1.length() - o2.length()));
        System.out.println("min:(hello!,world):  " + getMin("hello!", "world", (o1, o2) -> o1.charAt(0) - o2.charAt(0)));
    }

    public static Integer computer(int a, int b, BinaryOperator<Integer> binaryOperator) {
        return binaryOperator.apply(a, b);
    }

    public static String getMin(String a, String b, Comparator<String> comparator) {
        return BinaryOperator.minBy(comparator).apply(a, b);
    }
}
