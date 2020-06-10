package com.chriy.stream;

import java.util.*;
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
        List<Integer> list = Arrays.asList(1, 2, 3);
        int reduce = list.stream()
            .mapToInt(value -> value + 2)
            .reduce(1, (x, y) -> {
                System.out.println(x + " * " + y);
                return x * y;
            });
        System.out.println(reduce);
    }

    /**
     * Stream流的 collect方法
     */
    public static void collectTest() {
        // 对流中的每个元素进行合并，使之成为一个整体 ===> HiHelloYou
        Stream<String> streamJoin = Stream.of("Hi", "Hello", "You");
        System.out.println(streamJoin.collect(Collectors.joining()));

        /*
            将流处理后的结果转成一个List Collectors 类是个很强大的 类， 提供了很多将流转成对应 的集合
        */
        Stream<String> streamList = Stream.of("Hi", "Hello", "You");
        // 这种 toList 转换的是一个 ArrayList. 转换成其他类型的看下面的方法
        System.out.println(streamList.collect(Collectors.toList()));

        /*
            另外一种方式实现 流转换成 集合 利用的是 collect 重载的方法 具体看collect API的介绍
        */
        Stream<Integer> stream = Stream.of(1, 2, 3);
        // 需要啥类型的 List 就使用哪种
        List<Integer> list = stream.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        list.forEach(System.out::println);

        /*
            这种方式是先讲流转换称 Collection 集合, 再转称所需要的类型
         */
        Stream<String> hi = Stream.of("Hi", "Jer", "You");
        HashSet<String> set = hi.collect(Collectors.toCollection(HashSet::new));
        set.forEach(System.out::println);

    }

    public static void normalMethod() {
        // 取出大于5的元素, 全部乘以2, 丢掉前两个, 再取前两个, 求和
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(list.stream().filter(item -> item > 5).mapToInt(item -> item * 2).skip(2).limit(2).sum());

        // 取出大于5的元素, 全部乘以2, 丢掉前两个, 再取前两个, 找最小 最大
        list.stream().filter(item -> item > 5).mapToInt(item -> item * 2).skip(2).limit(2).min().ifPresent(System.out::println);
        list.stream().filter(item -> item > 5).mapToInt(item -> item * 2).skip(2).limit(2).max().ifPresent(System.out::println);

        // 同时取得最大, 最小, 求和, 平均值
        IntSummaryStatistics statistics = list.stream().filter(item -> item > 5).mapToInt(item -> item * 2).skip(2).limit(2).summaryStatistics();
        System.out.println(statistics.getSum());
        System.out.println(statistics.getMin());
        System.out.println(statistics.getMax());
        System.out.println(statistics.getAverage());
    }

    public static void main(String[] args) {
        StreamTest.normalMethod();
    }
}
