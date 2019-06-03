package com.rc.java8.stream;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName StreamTest4
 * @Description IntStream 简单实例 -- flatMap
 * @Author liux
 * @Date 19-5-25 下午3:29
 * @Version 1.0
 */
public class StreamTest4 {

    public static void main(String[] args) {
//        Stream<String> stream = Stream.of("a", "b", "c");
//        stream.map(String::toUpperCase).forEach(System.out::println);


//        flatMap1();
//        flatMap2();
//        flatMap3();
        flatMap4();


        /*Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());*/
    }


    private static void flatMap1() {
        Path path = Paths.get("/home/liux/IdeaProjects/java8/src/main/java/com/rc/java8/stream/demo");
        Stream<String> lines = null;
        try {
            lines = Files.lines(path, StandardCharsets.UTF_8);
            Stream<String> words = lines.flatMap(line -> {
                Stream<String> stream = Stream.of(line.split(" +"));
                System.out.println(stream.hashCode());
                return stream;
            });
            words.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void flatMap2() {
        Stream<List<Integer>> stream = Stream.of(Arrays.asList(1, 2),
                Arrays.asList(3, 4), Arrays.asList(5, 6, 7), Collections.singletonList(8));

        /*stream.flatMap(list -> {
            Stream<Integer> stream1 = list.stream();
            System.out.println("stream1: " + stream1.hashCode());
            return list.stream();
        }).map(o -> o * o).forEach(System.out::println);*/

        stream.flatMap(List::stream).map(o -> o * o).forEach(System.out::println);
    }

    private static void flatMap3() {
        Stream.of(new Integer[]{1, 2}, new Integer[]{3, 4}, new Integer[]{5, 6, 7},
                new Integer[]{8}).flatMap(arr -> {
                    Stream<Integer> stream = Stream.of(arr);
                    System.out.println("stream: " + stream.hashCode());
                    return stream;
                }
        ).map(o -> o * o).forEach(System.out::println);
    }

    private static void flatMap4() {
        Map<Integer, Integer> integerMap = new HashMap<>();

        Stream.of(new Integer[]{1, 2, 3}, new Integer[]{4, 5}, new Integer[]{6, 7},
                new Integer[]{8}).flatMap(Stream::of)
                .peek(o -> {
                    integerMap.put(o, o * o);
                }).forEach(integer ->
                System.out.println(integer + " : " + integerMap.get(integer)));
    }
}
