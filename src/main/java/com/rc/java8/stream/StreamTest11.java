package com.rc.java8.stream;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @ClassName StreamTest11
 * @Description TODO
 * @Author liux
 * @Date 19-5-26 上午10:34
 * @Version 1.0
 */
public class StreamTest11 {

    public static void main(String[] args) {
        Student student1 = new Student("zhangsan", 100, 20);
        Student student2 = new Student("lisi", 90, 20);
        Student student3 = new Student("wangwu", 90, 30);
        Student student4 = new Student("zhangsan", 80, 40);

        List<Student> list = Arrays.asList(student1, student2, student3, student4);

        //按照学生姓名进行分组
//        Map<String, List<Student>> map = list.stream().collect(Collectors.groupingBy(Student::getName));
        //按照学生年龄进行分组
//        Map<Integer, List<Student>> map = list.stream().collect(Collectors.groupingBy(Student::getAge));

        //按照学生姓名进行分组,并统计每组个数
//        Map<String, Long> map = list.stream().collect(Collectors.groupingBy(Student::getName, Collectors.counting()));


        //按照学生姓名进行分组,并统计每组平均分
//        Map<String, Double> map = list.stream().collect(Collectors.groupingBy(Student::getName, Collectors.averagingDouble(Student::getScore)));

        //按照学生分数是否大于90进行分区
        Map<Boolean, List<Student>> map = list.stream().collect(Collectors.partitioningBy(student -> student.getScore() >= 90));


        /*map.forEach((s, students) -> {
            System.out.println(s);
            students.forEach(System.out::println);
            System.out.println("-------------");
        });*/


        System.out.println(map);


    }

    private static void test1() {
        List<String> items =
                Arrays.asList("apple", "apple", "banana",
                        "apple", "orange", "banana", "papaya");

        Map<String, Long> result =
                items.stream().collect(
                        Collectors.groupingBy(Function.identity(), Collectors.counting())
                );

        System.out.println(result);

        Map<String, Long> finalMap = new LinkedHashMap<>();

        //Sort a map and add to finalMap
        result.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByKey()
                        .reversed()).forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));

        System.out.println(finalMap);
    }
}