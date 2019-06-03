package com.rc.java8.defaultmethod;

/**
 * @ClassName Interface1
 * @Description 默认方法示例接口
 * @Author liux
 * @Date 19-5-25 上午12:54
 * @Version 1.0
 */
public interface Interface1 {

    default void method() {
        System.out.println("Interface1");
    }
}