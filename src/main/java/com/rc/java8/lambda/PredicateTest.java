package com.rc.java8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @ClassName PredicateTest
 * @Description Predicate API测试
 * @Author liux
 * @Date 19-5-24 下午12:33
 * @Version 1.0
 */
public class PredicateTest {

    public static void main(String[] args) {



        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        //找奇数
        conditionFilter(list, i -> i % 2 != 0).forEach(System.out::println);
        System.out.println("-----------");
        //找偶数
        conditionFilter(list, i -> i % 2 == 0).forEach(System.out::println);
        System.out.println("-----------");
        //得到所有
        conditionFilter(list, i -> true).forEach(System.out::println);
        System.out.println("-----------");
        //哪个都不要
        conditionFilter(list, i -> false).forEach(System.out::println);
        System.out.println("-----------");
        //找出>2&&<5
        andConditionFilter(list, i -> i > 2, i -> i < 5).forEach(System.out::println);
        System.out.println("-----------");
        //找出>7 || 偶数
        orConditionFilter(list, i -> i > 7, i -> i % 2 == 0).forEach(System.out::println);
        System.out.println("-----------");
        //找偶数
        negateConditionFilter(list, i -> i % 2 != 0).forEach(System.out::println);
        System.out.println("-----------");

        String s = "Hello";
        boolean result = Predicate.isEqual(null).test(null);
        System.out.println("result: " + result);
        System.out.println(Predicate.isEqual(null));
        System.out.println("-----------");

        Predicate<String> predicate = "abc"::equals;
        result = predicate.test("abc");
        System.out.println(result);

    }

    private static List<Integer> conditionFilter(List<Integer> list, Predicate<Integer> predicate) {
        return list.stream().filter(predicate).collect(Collectors.toList());
    }

    private static List<Integer> andConditionFilter(List<Integer> list, Predicate<Integer> p1, Predicate<Integer> p2) {
        return list.stream().filter(p1.and(p2)).collect(Collectors.toList());
    }

    private static List<Integer> orConditionFilter(List<Integer> list, Predicate<Integer> p1, Predicate<Integer> p2) {
        return list.stream().filter(p1.or(p2)).collect(Collectors.toList());
    }

    private static List<Integer> negateConditionFilter(List<Integer> list, Predicate<Integer> p) {
        return list.stream().filter(p.negate()).collect(Collectors.toList());
    }
}
