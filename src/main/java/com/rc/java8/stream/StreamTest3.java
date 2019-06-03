package com.rc.java8.stream;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName StreamTest3
 * @Description IntStream 简单实例 stream 到集合(array,list,set),string 的转换
 * @Author liux
 * @Date 19-5-25 下午12:07
 * @Version 1.0
 */
public class StreamTest3 {

    public static void main(String[] args) {
//        streamToStringArray();
//        streamToIntegerArray();

        streamToString();
//        streamToList();

//        streamToLis2();


//        streamToSet();
    }

    private static void streamToSet() {
        Stream<String> stream = Stream.of("a", "b", "c");
//        System.out.println(stream.collect(Collectors.toCollection(TreeSet::new)).getClass());
        System.out.println(stream.collect(Collectors.toCollection(HashSet::new)).getClass());
    }


    //可以选择 LinkedList 或者 ArrayList
    private static void streamToLis2() {
        Stream<String> stream = Stream.of("a", "b", "c");
//        stream.collect(Collectors.toCollection(LinkedList::new)).forEach(System.out::println);
//        stream.collect(Collectors.toCollection(ArrayList::new)).forEach(System.out::println);


    }

    private static void streamToString() {
        Stream<String> stream = Stream.of("a", "b", "c");
        String result;

        //极简版
//        result = stream.collect(Collectors.joining());

        //以下为复杂版
        //lambda 完整写法
        result = stream.collect(new Supplier<StringBuilder>() {
            @Override
            public StringBuilder get() {
                StringBuilder stringBuilder = new StringBuilder();
                System.out.println("1: " + stringBuilder.hashCode());
                return stringBuilder;
            }
        }, new BiConsumer<StringBuilder, String>() {
            @Override
            public void accept(StringBuilder stringBuilder, String s) {
                stringBuilder.append(s);
                System.out.println("2: " + stringBuilder.hashCode() + " , " + s);
            }
        }, new BiConsumer<StringBuilder, StringBuilder>() {
            @Override
            public void accept(StringBuilder stringBuilder, StringBuilder stringBuilder2) {
                System.out.println("3: " + stringBuilder.hashCode() + " , " + stringBuilder2.hashCode());
//                stringBuilder.append(stringBuilder2);
            }
        }).toString();

        //lambda 简化写法
        /*result = stream.collect(() -> new StringBuilder(),
                (stringBuilder, s) -> stringBuilder.append(s),
                (stringBuilder, stringBuilder2) -> stringBuilder.append(stringBuilder2)).toString();*/

        //方法引用
//        result = Stream.of("a", "b", "c").collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
        System.out.println("result:" + result);
    }


    private static void streamToList() {
        Stream<String> stream = Stream.of("a", "b", "c");
        List<String> list;
        //极简版
//        list = stream.collect(Collectors.toList());

        //以下为复杂版
        //lambda 完整写法
        list = stream.collect(new Supplier<List<String>>() {
            @Override
            public List<String> get() {
                List<String> tempList = new ArrayList<>();
                System.out.println("1: " + tempList.hashCode());
                return tempList;
            }
        }, new BiConsumer<List<String>, String>() {

            @Override
            public void accept(List<String> strings, String s) {
                System.out.println("2: " + strings.hashCode() + " , " + s);
                strings.add(s);
            }
        }, new BiConsumer<List<String>, List<String>>() {
            @Override
            public void accept(List<String> strings, List<String> strings2) {
                System.out.println("3: " + strings.hashCode() + " , " + strings2.hashCode());
//                strings2.addAll(strings);
            }
        });


        //lambda 简化写法
        /*list = stream.collect(() -> new ArrayList<>(),
                (strings, s) -> strings.add(s),
                (strings, strings2) -> strings2.addAll(strings) );*/

        //方法引用
//        list = stream.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        list.forEach(System.out::println);


    }

    private static void streamToStringArray() {
        Stream<String> stream = Stream.of("a", "b", "c");

        //强转报错
        /*String[] arr = (String[]) stream.toArray();
        for (String s : arr) {
            System.out.println(s);
        }*/

        //lambda 完全形式
        /*String[] arr = stream.toArray(new IntFunction<String[]>() {
            @Override
            public String[] apply(int value) {
                return new String[value];
            }
        });*/


        //lambda 简写
//        String[] arr = stream.toArray(length->new String[length]);

        //method reference
        String[] arr = stream.toArray(String[]::new);
        Arrays.asList(arr).forEach(System.out::println);
    }

    private static void streamToIntegerArray() {
        Stream<Integer> stream = Stream.of(1, 2, 3);
        //强转报错
        /*Integer[] arr = (Integer[]) stream.toArray();
        for (Integer integer : arr) {
            System.out.println(integer);
        }*/

        //lambda 完全形式
        /*Integer[] arr = stream.toArray(new IntFunction<Integer[]>() {
            @Override
            public Integer[] apply(int value) {
                return new Integer[value];
            }
        });*/


        //lambda 简写
//        Integer[] arr = stream.toArray(length->new Integer[length]);

        //method reference
        Integer[] arr = stream.toArray(Integer[]::new);
        Arrays.asList(arr).forEach(System.out::println);
    }


}
