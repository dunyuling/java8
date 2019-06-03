package com.rc.java8.stream2;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collector;

import static java.util.stream.Collectors.*;


/**
 * @ClassName StreamTest1
 * @Description Collector 简单示例, Collector 可以复合
 * @Author liux
 * @Date 19-5-26 下午2:51
 * @Version 1.0
 */
public class StreamTest1 {

    public static void main(String[] args) {
        Student student1 = new Student("zhangsan", 80);
        Student student2 = new Student("lisi", 90);
        Student student3 = new Student("wangwu", 100);
        Student student4 = new Student("maliu", 100);
        Student student5 = new Student("maliu", 100);
        List<Student> list = Arrays.asList(student1, student2, student3, student4, student5);

        //统计学生数量
        /*System.out.println("count: " + list.stream().count());
        System.out.println("count: " + list.stream().collect(counting()));
        System.out.println("---------");*/

        //获取分数最低的学生
        /*list.stream().collect(minBy(Comparator.comparingInt(Student::getScore)))
                .ifPresent(System.out::println);
        //获取分数最高的学生
        list.stream().collect(maxBy(Comparator.comparingInt(Student::getScore)))
                .ifPresent(System.out::println);
        //获取学生分数平均值
        double averageScore = list.stream().collect(averagingDouble(Student::getScore));
        System.out.println("averageScore: " + averageScore);
        //获取学生总分
        double totalScore = list.stream().collect(summarizingDouble(Student::getScore)).getSum();
        System.out.println("totalScore: " + totalScore);
        //获取学生分数汇总信息
        DoubleSummaryStatistics summarizingDouble = list.stream().collect(summarizingDouble(Student::getScore));
        System.out.println("汇总信息: " + summarizingDouble);
        System.out.println("---------");*/

        //连接字符串
        /*String nameJoin = list.stream().map(Student::getName).collect(joining(", "));
        System.out.println("nameJoin: " + nameJoin);
        nameJoin = list.stream().map(Student::getName).collect(joining(", ", "(", ")"));
        System.out.println("nameJoin: " + nameJoin);
        System.out.println("---------");*/

        //先按照分数分组,再按照名字分组
        /*Map<Integer, Map<String, List<Student>>> map = list.stream().collect(groupingBy(Student::getScore, groupingBy(Student::getName)));
//        map.keySet().stream().forEach(score -> {
////            System.out.println(score + ": " + map.get(score));
//            System.out.println(score + ": ");
//            Map<String, List<Student>> map2 = map.get(score);
//            map2.keySet().stream().forEach(name -> {
//                System.out.println(name);
//                System.out.println(map2.get(name));
//            });
//            System.out.println("-------");
//        });
        System.out.println(map);
        System.out.println("---------");*/

        //按照学生分数是否大于等于90进行分区
        /*Map<Boolean,List<Student>> map = list.stream().collect(partitioningBy(student -> student.getScore() >= 90));
        System.out.println(map);
        System.out.println("---------");*/

        //先按照学生分数是否大于80进行分区,再按照学生分数是否大于90进行分区
       /* Map<Boolean, Map<Boolean, List<Student>>> map = list.stream()
                .collect(partitioningBy(student -> student.getScore() > 80, partitioningBy(student -> student.getScore() > 90)));
        System.out.println(map);
        System.out.println("---------");*/


        //求出大于80的学生,并统计数量
        /*Map<Boolean, Long> map = list.stream().collect(partitioningBy(student -> student.getScore() > 80, counting()));
        System.out.println(map);
        System.out.println("---------");*/

        //根据名字进行分组,在获取每组里面分数最低的学生
        //map为map2的简便获得方式
        Map<String, Student> map = list.stream().
                collect(toMap(Student::getName, student -> student, BinaryOperator.minBy(Comparator.comparingInt(Student::getScore))));

        Map<String, Student> map2 =
                list.stream().collect(groupingBy(Student::getName,
                        collectingAndThen(minBy(Comparator.comparingInt(Student::getScore)), Optional::get)
                ));

        Map<String, Optional<Student>> map3 = list.stream().collect(groupingBy(Student::getName, minBy(Comparator.comparingInt(Student::getScore))));

        System.out.println(map);
        System.out.println(map2);
        System.out.println(map3);
        System.out.println("---------");


    }
}
