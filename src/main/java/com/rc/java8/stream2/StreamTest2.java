package com.rc.java8.stream2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @ClassName StreamTest2
 * @Description 测试BaseStream::onClose()
 * @Author liux
 * @Date 19-5-31 下午4:00
 * @Version 1.0
 */
public class StreamTest2 {

    public static void main(String[] args) {

        /*close1();
        System.out.println("---------------");
        close2();
        System.out.println("---------------");*/
        closeWithException();
        System.out.println("---------------");
    }

    private static void closeWithException() {
        List<String> list = Arrays.asList("a", "b", "c", "d");
        RuntimeException runtimeException = new RuntimeException("aa Exception");
        try (Stream<String> stream = list.stream()) {
            stream.onClose(() -> {
                System.out.println("aa");
                throw runtimeException;
            }).onClose(() -> {
                System.out.println("bb");
                throw runtimeException;
            }).onClose(() -> {
                System.out.println("cc");
                throw new RuntimeException("cc Exception");
            }).forEach(System.out::println);
        }
    }

    private static void close2() {
        List<String> list = Arrays.asList("a", "b", "c", "d");

        Stream<String> stream = list.stream();

        stream.onClose(() -> {
            System.out.println("aa");
        }).onClose(() -> {
            System.out.println("bb");
        }).forEach(System.out::println);
        stream.close();

    }

    private static void close1() {

        List<String> list = Arrays.asList("a", "b", "c", "d");
        try (Stream<String> stream = list.stream()) {
            stream.onClose(() -> {
                System.out.println("aa");
            }).onClose(() -> {
                System.out.println("bb");
            }).forEach(System.out::println);
        }
    }


}
