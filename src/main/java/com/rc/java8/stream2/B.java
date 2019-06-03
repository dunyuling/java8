package com.rc.java8.stream2;

/**
 * @ClassName B
 * @Description TODO
 * @Author liux
 * @Date 19-6-2 下午3:25
 * @Version 1.0
 */
public class B extends A {

    abstract static class Op {

        abstract void testXX();

        final boolean aa() {
            return false;
        }
    }
}
