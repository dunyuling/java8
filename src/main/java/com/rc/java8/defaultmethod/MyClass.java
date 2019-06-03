package com.rc.java8.defaultmethod;

/**
 * @ClassName MyClass
 * @Description 同时实现两个接口,且两个接口包含相同描述的方法时,实现类需要重写该方法
 * @Author liux
 * @Date 19-5-25 上午12:55
 * @Version 1.0
 */
public class MyClass implements Interface1, Interface2 {

    @Override
    public void method() {
        System.out.println(Interface2.super.toString());
        Interface2.super.method();

    }

    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.method();
    }
}
