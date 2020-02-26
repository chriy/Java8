package com.chriy.consumer;

import java.util.function.Consumer;

/**
 * @author chriy
 * @version 1.0
 * @date 2020.02.26 23:30
 */
public class ConsumerTest {
    /**
     * 消费者 andThen 多个操作
     *
     * @param str       输入的 对象
     * @param consumer1 消费操作 1
     * @param consumer2 消费操作 2
     */
    public static void andThen(String str,
                               Consumer<String> consumer1,
                               Consumer<String> consumer2) {
        consumer1.andThen(consumer2).accept(str);
    }

    public static void main(String[] args) {
        // 简单测试
        Consumer<String> consumer = value -> System.out.println(value);
        consumer.accept("Hello");

        ConsumerTest.andThen("hello",
            value -> System.out.println(value.length()), value -> System.out.println(value));
    }
}
