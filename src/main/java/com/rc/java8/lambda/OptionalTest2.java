package com.rc.java8.lambda;

import java.util.*;

/**
 * @ClassName OptionalTest2
 * @Description 模拟实际应用中的 Optional 用法
 * @Author liux
 * @Date 19-5-24 下午6:32
 * @Version 1.0
 */
public class OptionalTest2 {

    public static void main(String[] args) throws Throwable {
        Child child1 = new Child("老大");
        Child child2 = new Child("老二");

        Parent parent = new Parent("老爸");

        List<Child> children = Arrays.asList(child1, child2);
//        parent.setChildren(children);

        Optional<Parent> optional = Optional.ofNullable(parent);

        optional.map(Parent::getChildren)
//                .orElseGet(ArrayList::new)
                .orElse(Collections.emptyList())
//                .orElseThrow((Supplier<Throwable>) () -> new RuntimeException("abcde"))
                .forEach(System.out::println);

        System.out.println(optional.map(Parent::getChildren).orElse(Collections.emptyList()));
    }
}
