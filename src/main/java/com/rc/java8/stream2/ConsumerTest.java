package com.rc.java8.stream2;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

/**
 * @ClassName ConsumerTest
 * @Description Consumer(function interface的继承关系,缘起
 *          {@link java.util.Spliterator.OfInt#tryAdvance(java.util.function.Consumer)}
 * @Author liux
 * @Date 19-6-1 下午4:31
 * @Version 1.0
 */
public class ConsumerTest {

    public static void main(String[] args) {



        //上下文1
        /*test((Consumer<Integer>) integer -> System.out.println("Consumer: " + integer));
        test((IntConsumer) integer -> System.out.println("Consumer: " + integer));

        test1(value -> System.out.println("IntConsumer: " + value));*/

        //上下文2
        Consumer<Integer> consumer = i -> {
            System.out.println("Consumer: " + i);
        };
        IntConsumer intConsumer = i -> {
            System.out.println("IntConsumer: " + i);
        };

        System.out.println(consumer instanceof Consumer);
        System.out.println(intConsumer instanceof IntConsumer);
        System.out.println("------------");

        test(consumer);//对象方式
        test((Consumer<Integer>) consumer::accept);//函数式方式
        test((IntConsumer) consumer::accept);//不是父子类,却能实现强制类型转换.函数式关注的是实际的执行
        test(intConsumer);
        test((IntConsumer)intConsumer::accept);
        test((Consumer<Integer>)intConsumer::accept);



    }

    private static void test(Consumer<Integer> consumer) {
        consumer.accept(100);
    }

    private static void test(IntConsumer consumer) {
        consumer.accept(100);
    }

    /*private static void test1(IntConsumer consumer) {
        consumer.accept(100);
    }*/
}
