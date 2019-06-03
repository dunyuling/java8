package com.rc.java8.stream2;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @ClassName LambdaTest
 * @Description lambda表达式与匿名内部类的区别,通过 this 观察
 * @Author liux
 * @Date 19-6-2 下午5:01
 * @Version 1.0
 */
public class LambdaTest {

    Runnable r1 = () -> System.out.println("r1: " + this);

    Runnable r2 = new Runnable() {
        @Override
        public void run() {
            System.out.println("r2: " + this);
        }
    };

    public static void main(String[] args) {
        LambdaTest lambdaTest = new LambdaTest();
        System.out.println("lambdaTest: " + lambdaTest);

        Thread t1 = new Thread(lambdaTest.r1);
        t1.start();

        Thread t2 = new Thread(lambdaTest.r2);
        t2.start();

    }
}
