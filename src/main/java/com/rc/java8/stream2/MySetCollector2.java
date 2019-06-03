package com.rc.java8.stream2;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import static java.util.stream.Collector.Characteristics.*;

/**
 * @ClassName MySetCollector2
 * @Description TODO
 * @Author liux
 * @Date 19-5-28 上午11:47
 * @Version 1.0
 */
public class MySetCollector2<T> implements Collector<T, Map<T, T>, Map<T, T>> {

    @Override
    public Supplier<Map<T, T>> supplier() {
        System.out.println("supplier invoked!");
        return HashMap::new;
    }


    @Override
    public BiConsumer<Map<T, T>, T> accumulator() {
        System.out.println("accumulator invoked!");
        return (Map<T, T> map, T item) -> {
            System.out.println("accumulator map: " + map);
            map.put(item, item);
        };
    }

    @Override
    public BinaryOperator<Map<T, T>> combiner() {
        System.out.println("combiner invoked!");
        return (Map<T, T> map1, Map<T, T> map2) -> {
            System.out.println("combiner map2: " + map2 + ", map1: " + map1);
            map1.putAll(map2);
            return map1;
        };
    }

    @Override
    public Function<Map<T, T>, Map<T, T>> finisher() {
        System.out.println("finisher invoked!");
        return t -> t;
    }

    @Override
    public Set<Characteristics> characteristics() {
        System.out.println("characteristics invoked!");

        return Collections.unmodifiableSet(EnumSet.of(IDENTITY_FINISH, UNORDERED));
    }

    public static void main(String[] args) {
        Set<String> set = new HashSet<>(Arrays.asList("a", "b", "c", "d", "a"));
        Map<String, String> map = set.stream().collect(new MySetCollector2<>());
        System.out.println(map);
    }
}
