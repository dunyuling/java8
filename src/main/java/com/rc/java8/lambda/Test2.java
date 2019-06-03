package com.rc.java8.lambda;

/**
 * @ClassName Test2
 * @Description 用Function Interface注解的接口 可以有默认方法,静态方法
 * @Author liux
 * @Date 19-5-23 下午3:29
 * @Version 1.0
 */
public class Test2 {

    public void test2(InterfaceTwo interfaceTwo) {
        System.out.println("begin");
        interfaceTwo.test();
        interfaceTwo.test2();
        System.out.println("end");
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        test2.test2(() -> System.out.println("InterfaceTwo test"));
        System.out.println("--------------");
        InterfaceTwo.test3();
    }

}

@FunctionalInterface
interface InterfaceTwo {
    void test();

    String toString();

    default void test2() {
        System.out.println("InterfaceTwo test2");
    }

    static void test3() {
        System.out.println("InterfaceTwo test3");
    }
}
