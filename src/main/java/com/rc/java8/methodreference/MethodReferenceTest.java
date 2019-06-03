package com.rc.java8.methodreference;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @ClassName MethodReferenceTest
 * @Description 测试方法引用
 * @Author liux
 * @Date 19-5-24 下午8:10
 * @Version 1.0
 */
public class MethodReferenceTest {

    public static void main(String[] args) {
        /*List<String> list = Arrays.asList("a", "b", "c");
        list.forEach(System.out::println);*/

        Student student1 = new Student("zhangsan", 10);
        Student student2 = new Student("lisi", 90);
        Student student3 = new Student("wangwu", 50);
        Student student4 = new Student("maliu", 40);

        List<Student> list = Arrays.asList(student1, student2, student3, student4);

        //类名::静态方法名
        /*list.sort(StudentComparator::compareStudentByScore1);
        list.forEach(System.out::println);
        System.out.println("--------------");
        list.sort(StudentComparator::compareStudentByName1);
        list.forEach(System.out::println);
        System.out.println("--------------");*/

        //引用名(对象名)::实例方法名
        /*StudentComparator studentComparator = new StudentComparator();
        list.sort(studentComparator::compareStudentByScore2);
        list.forEach(System.out::println);
        System.out.println("--------------");
        list.sort(studentComparator::compareStudentByName2);
        list.forEach(System.out::println);
        System.out.println("--------------");*/

        //类名::实例方法名
        /*list.sort((Student::compareByScore));
        list.forEach(System.out::println);
        System.out.println("--------------");
        list.sort((Student::compareByName));
        list.forEach(System.out::println);
        System.out.println("--------------");*/

        //类名::new
        MethodReferenceTest methodReferenceTest = new MethodReferenceTest();
        String result;
        //a等价于b(a <==> b)
        a:
        {
            result = methodReferenceTest.getString(() -> "");
            System.out.println("result: " + result);
            System.out.println("--------------");
        }
        b:
        {
            result = methodReferenceTest.getString(String::new);
            System.out.println("result: " + result);
            System.out.println("--------------");
        }


        //c等价于d(c <==> d)
        c:
        {
            result = methodReferenceTest.getString2("hello", str -> str);
            System.out.println("result: " + result);
            System.out.println("--------------");
        }
        d:
        {
            result = methodReferenceTest.getString2("hello", String::new);
            System.out.println("result: " + result);
            System.out.println("--------------");
        }
    }

    public String getString(Supplier<String> supplier) {
        return supplier.get() + " test";
    }

    public String getString2(String str, Function<String, String> function) {
        return function.apply(str);
    }
}
