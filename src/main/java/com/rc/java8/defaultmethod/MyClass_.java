package com.rc.java8.defaultmethod;

/**
 * @ClassName MyClass_
 * @Description 实现类的优先级高于接口的优先级
 * @Author liux
 * @Date 19-5-25 上午1:03
 * @Version 1.0
 */
public class MyClass_ extends Interface1Impl implements Interface2 {

    public static void main(String[] args) {
        MyClass_ myClass_ = new MyClass_();
        myClass_.method();
    }
}
