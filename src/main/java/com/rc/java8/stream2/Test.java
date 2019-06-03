package com.rc.java8.stream2;

import java.util.HashMap;
import java.util.Map;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/**
 * @ClassName Test
 * @Description TODO
 * @Author liux
 * @Date 19-5-29 上午3:13
 * @Version 1.0
 */
public class Test implements Cloneable {

    private String name;

    public Test(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Test{" +
                "name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        /*Test test = new Test("aaa");
        Test test1 = (Test) test.clone();
        System.out.println(test1.hashCode());
        System.out.println(test.hashCode());*/

        Map<String, String> map = new HashMap<>();
        map.put("a", "a1");

        /*Map<String,String> map2 = (Map<String, String>) ((HashMap<String, String>) map).clone();
        System.out.println(map2);

        System.out.println(map.equals(map2));*/


//        System.out.println(1<<30);
//        float f = 1.2F;
        /*int a = 1;
        int b = 2;
        double c =  1 /(double) 2;
        System.out.println(c);

        System.out.println(-5%3);

        System.out.println(4>>>1);*/

        /*long begin = System.nanoTime();
        for (int i = 0; i < 127000000; i++) {

        }
        long end = System.nanoTime();
        System.out.println("duration: " + TimeUnit.NANOSECONDS.toMillis(end - begin));*/


        System.out.println((2>>>1)&(~1));
        System.out.println(~1);



    }
}