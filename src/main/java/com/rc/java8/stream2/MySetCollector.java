package com.rc.java8.stream2;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import static java.util.stream.Collector.Characteristics.*;

/**
 * @ClassName MySetCollector
 * @Description 自定义Set 收集器---不使用finisher方法时似乎没有必要自定义转换器
 * @Author liux
 * @Date 19-5-27 下午10:13
 * @Version 1.0
 */
public class MySetCollector<T> implements Collector<T, Set<T>, Set<T>> {
    @Override
    public Supplier<Set<T>> supplier() {
        System.out.println("supplier invoked!");
        return HashSet::new;
    }

    @Override
    public BiConsumer<Set<T>, T> accumulator() {
        System.out.println("accumulator invoked!");

//        return Set<T>::add;
        return (set, item) -> set.add(item);
    }

    @Override
    public BinaryOperator<Set<T>> combiner() {
        System.out.println("combiner invoked!");

        return (ts, ts2) -> {
            ts.addAll(ts2);
            System.out.println("ts: " + ts);
            return ts;
        };
    }

    @Override
    public Function<Set<T>, Set<T>> finisher() {
        System.out.println("finisher invoked!");

//        throw new RuntimeException("Not Needed!");
//        return Function.identity();
        return ts -> ts;
    }

    @Override
    public Set<Characteristics> characteristics() {
        System.out.println("characteristics invoked!");
        return Collections.unmodifiableSet(EnumSet.of(UNORDERED, CONCURRENT, IDENTITY_FINISH));
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c", "d", "a");
        Set<String> set;
        //使用自定义转换器
//        set = list.stream().collect(new MySetCollector<>());
//        set = list.stream().parallel().collect(new MySetCollector<>());
//        System.out.println("set: " + set);

        //使用系统的转换器
        //原始版
        /*Set<String> set = list.stream().collect(HashSet::new, new BiConsumer<HashSet<String>, String>() {
            @Override
            public void accept(HashSet<String> strings, String s) {
                strings.add(s);
            }

        }, new BiConsumer<HashSet<String>, HashSet<String>>() {
            @Override
            public void accept(HashSet<String> strings, HashSet<String> strings2) {
                System.out.println("hello"); //parallel()的情况下才会调用
                strings.addAll(strings2);
            }
        });*/

        //lambda 版
        /*set = list.stream().parallel().collect(HashSet::new, (HashSet<String> set1, String item) -> set1.add(item),
                (HashSet<String> strings, HashSet<String> strings2) -> strings.addAll(strings2));*/

        //方法引用版
//        set = list.stream().collect(HashSet::new, HashSet::add, HashSet::addAll);

        set = new HashSet<>(list);
        System.out.println("set: " + set);

        List<String> list2 = new ArrayList<>(set);
        System.out.println(list2);
    }
}
