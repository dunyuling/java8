package com.rc.java8.stream2;

import java.util.Arrays;

/**
 * @ClassName AutoCloseableTest
 * @Description 测试 AutoCloseable 接口
 * @Author liux
 * @Date 19-5-29 上午1:34
 * @Version 1.0
 */
public class AutoCloseableTest implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("close invoked!");
    }

    private void doSth() {
        System.out.println("doSth invoked!");
    }

    public static void main(String[] args) throws Exception {
        try (AutoCloseableTest autoCloseableTest = new AutoCloseableTest()) {
            autoCloseableTest.doSth();
        }



    }
}
