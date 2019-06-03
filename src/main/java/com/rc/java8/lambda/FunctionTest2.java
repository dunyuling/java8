package com.rc.java8.lambda;

import java.util.function.Function;

/**
 * @ClassName FunctionTest2
 * @Description Function类简单用例
 * @Author liux
 * @Date 19-5-23 下午11:21
 * @Version 1.0
 */
public class FunctionTest2 {

    public static void main(String[] args) {
        FunctionTest2 functionTest2 = new FunctionTest2();
        //传递行为
        //其实就是:
        //1.在形参处保留一个Function接口的引用
        //2.实际使用的时候再实例化Function接口对象(在堆中),定义具体的apply方法内容;
        //3.形参调用apply方法,就相当于已经实例化的对象内定义的apply方法的执行
        System.out.println("---------");//一次性
        System.out.println(functionTest2.compute(1, a -> a + 1));
        System.out.println(functionTest2.compute(2, a -> a * a));

        System.out.println("----------");//类内复用
        System.out.println(functionTest2.compute(3, doubleTimes()));
        System.out.println(functionTest2.compute(4, doubleTimes()));

        System.out.println("------------");//局部复用
        Function<Integer, Integer> fiveTimes = integer -> 5 * integer;
        System.out.println(functionTest2.compute(5,fiveTimes));
    }

    private static Function<Integer, Integer> doubleTimes() {
        return value -> 2 * value;
    }

    //high-order function(高阶函数)
    private int compute(int a, Function<Integer, Integer> function) {
        return function.apply(a);
    }
}



