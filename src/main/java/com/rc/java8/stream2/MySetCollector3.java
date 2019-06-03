package com.rc.java8.stream2;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import static java.util.stream.Collector.Characteristics.CONCURRENT;
import static java.util.stream.Collector.Characteristics.UNORDERED;

/**
 * @ClassName MySetCollector3
 * @Description 收集器类型和结果类型不一致时, 必须保证finisher()方法被调用,
 * 即不能有 Characteristics.IDENTITY_FINISH 特征
 * @Author liux
 * @Date 19-5-28 下午12:14
 * @Version 1.0
 */
public class MySetCollector3<T> implements Collector<T, Set<T>, Map<T, T>> {
    @Override
    public Supplier<Set<T>> supplier() {
        System.out.println("supplier invoked!");

        return () -> {
            Set<T> hashSet = new HashSet<>();
            System.out.println("supplier: " + Thread.currentThread().getName()
                    + " =========== " + hashSet.toString());
            return hashSet;
        };
//        return HashSet::new;
    }

    @Override
    public BiConsumer<Set<T>, T> accumulator() {
        System.out.println("accumulator invoked!");
        return (Set<T> set, T t) -> {
            System.out.println("accumulator set: " + set + ", current thread: " + Thread.currentThread().getName());
            set.add(t);
        };
    }

    @Override
    public BinaryOperator<Set<T>> combiner() {
        System.out.println("combiner invoked!");
        return (set1, set2) -> {
            System.out.println("combiner set1: " + set1 + ", set2: " + set2);
            set1.addAll(set2);
            return set1;
        };
    }

    @Override
    public Function<Set<T>, Map<T, T>> finisher() {
        System.out.println("finisher invoked!");
        return ts -> {
            Map<T, T> map = new HashMap<>();
            ts.forEach(t -> map.put(t, t));
            return map;
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        System.out.println("characteristics invoked!");

        return Collections.unmodifiableSet(EnumSet.of(UNORDERED));
    }

    public static void main(String[] args) {
        Set<String> set = new HashSet<>(Arrays.asList("a", "b", "c", "d", "a", "e", "f", "g"));
        int i = 0;
        System.out.println(Runtime.getRuntime().availableProcessors());
        while (i < 1) {
            try {
                Map<String, String> map = set.stream().parallel().collect(new MySetCollector3<>());
                System.out.println(map);
                System.out.println("-----------------" + i);
                i++;
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
