package com.chriy.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 流的简单应用
 *
 * @author chriy
 * @version 1.0
 * @date 2020.02.28 11:56
 */
public class StreamTest {
    /**
     * 基本创建
     */
    public static void base() {
        // 传入数组(of传的的可变参数)创建流
        IntStream.of(1, 2, 3, 4, 5).forEach(System.out::println);

        // 用range 创建一个区间的流 , 1-10 不包含10
        IntStream.range(1, 10).forEach(System.out::println);

        // 用range 创建一个区间的流, 1-10 包含10
        IntStream.rangeClosed(1, 10).forEach(System.out::println);

        Stream<String> stream = Stream.of("hello", "hi", "you");
    }

    /**
     * 对 list 中的每个数加 2 在进行累加或这累乘
     */
    public static void mapReduce() {
        List<Integer> list = List.of(1, 2, 3);
        var result =
            list.stream()
                .mapToInt(value -> value + 2)
                .reduce(1, (x, y) -> {
                    System.out.println(x + " * " + y);
                    return x * y;
                });
        System.out.println(result);
    }

    /**
     * Stream流的 collect方法
     */
    public static void collectTest(){
        // 对流中的每个元素进行合并，使之成为一个整体 ===> HiHelloYou
        Stream<String> streamJoin = Stream.of("Hi","Hello","You");
        System.out.println(streamJoin.collect(Collectors.joining()));
        /* 将流处理后的结果转成一个List
         * Collectors 类是个很强大的
         * 类， 提供了很多将流转成对应
         * 的集合
         */
        Stream<String> streamList = Stream.of("Hi","Hello","You");
        System.out.println(streamList.collect(Collectors.toList()));
    }

    public static void main(String[] args) {
        StreamTest.collectTest();
    }
}
