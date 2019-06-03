package com.rc.java8.stream;

import java.util.IntSummaryStatistics;
import java.util.stream.Stream;

/**
 * @ClassName StreamTest5
 * @Description Stream 构造实例 --- generate,iterate
 * @Author liux
 * @Date 19-5-25 下午5:10
 * @Version 1.0
 */
public class StreamTest5 {

    public static void main(String[] args) {
        //generate
        /*List<Integer> list = Arrays.asList(1, 2, 3);
        Stream.generate(() -> list).findFirst().get().forEach(System.out::println);
        System.out.println("-------------");
        Stream.generate(UUID.randomUUID()::toString).findFirst().ifPresent(System.out::println);
        System.out.println("-------------");
        Stream.empty().findFirst().ifPresent(System.out::println);
        System.out.println("-------------");*/

//        Stream.iterate(1, t -> t + 1).limit(8).forEach(System.out::println);
        Stream.iterate(1, t -> t + 2)
                .limit(6)
                .filter(x -> x > 2)
                .map(x -> x * 2)
                .skip(2)
                .limit(2)
                .reduce((integer, integer2) -> integer + integer2)
                .ifPresent(System.out::println);


        int sum = Stream.iterate(1, t -> t + 2)
                .limit(6)
                .filter(x -> x > 2)
                .mapToInt(x -> x * 2)
                .skip(2)
                .limit(2).sum();
        System.out.println("sum: " + sum);
        System.out.println("-------------");

        Stream.iterate(1, t -> t + 2)
                .limit(6)
                .filter(x -> x > 2)
                .mapToInt(x -> x * 2)
                .skip(2)
                .limit(2)
                .min()
                .ifPresent(System.out::println);
        System.out.println("-------------");

        IntSummaryStatistics intSummaryStatistics = Stream.iterate(1, t -> t + 2)
                .limit(6)
                .filter(x -> x > 2)
                .mapToInt(x -> x * 2)
                .skip(2)
                .limit(2).summaryStatistics();
        System.out.println(intSummaryStatistics.toString());
        System.out.println("-------------");

        Stream stream = Stream.iterate(1, t -> t + 2).limit(6);
        System.out.println(stream);
    }
}
