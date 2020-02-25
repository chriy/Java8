package com.chriy.lambda;

import java.util.List;

/**
 * @author chriy
 * @version 1.0
 * @date 2020.02.24 20:12
 */
public class LambdaTest {

    public static void main(String[] args) {

        // 对自定义函数式接口的一个实现，传递行为，输出一句话
        //FuncInterface funcInterface = () -> System.out.println("你好呀！");
        // 调用
        //funcInterface.say();

        List<String> list = List.of("hello", "hi", "you");
//        list.forEach(item -> System.out.println(item.toUpperCase()));
        list.stream().map(String::toUpperCase).forEach(System.out::println);

//        List<Integer> list = List.of(1, 2, 3, 4);
//        list.forEach(System.out::println);
//        Integer reduce = list.stream().reduce(0, Integer::sum);
//        System.out.println(reduce);
//
//        System.out.println(list.stream().reduce(0, (a, b) -> {
//            System.out.println(a + "==" + b);
//            return a;
//        }));
    }
}
