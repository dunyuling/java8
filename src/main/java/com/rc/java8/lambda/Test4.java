package com.rc.java8.lambda;

/**
 * @ClassName Test4
 * @Description Lambda实际上下文
 * @Author liux
 * @Date 19-5-23 下午5:07
 * @Version 1.0
 */
public class Test4 {

    public static void main(String[] args) {
        //如何判定lambda表达式的上下文
        InterfaceThree interfaceThree = () -> {};
        System.out.println(interfaceThree.getClass().getInterfaces()[0]);
        InterfaceFour interfaceFour = () -> {};
        System.out.println(interfaceFour.getClass().getInterfaces()[0]);


    }
}

@FunctionalInterface
interface InterfaceThree {
    void test3();
}

@FunctionalInterface
interface InterfaceFour {
    void test4();
}
