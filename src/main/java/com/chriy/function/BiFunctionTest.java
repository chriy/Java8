package com.chriy.function;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author chriy
 * @version 1.0
 * @date 2020.02.25 23:13
 */
public class BiFunctionTest {

    /**
     * 计算两个数的值
     *
     * @param x      值 x
     * @param y      值 y
     * @param biFunc 传入的操作
     * @return 返回的结果
     */
    public static int calc(int x, int y, BiFunction<Integer, Integer, Integer> biFunc) {
        return biFunc.apply(x, y);
    }

    /**
     * 先执行 Function 的操作
     * 再执行 BiFunction 的操作
     * @param x 值 x
     * @param y 值 y
     * @param biFunc 传入两个参数的操作
     * @param func 传入一个参数的操作(再进行两个参数操作前,先对某个参数进行操作一波作为结果返回)
     * @return 返回结果
     */
    public static int andThenCalc(int x, int y,
                                  BiFunction<Integer, Integer, Integer> biFunc,
                                  Function<Integer, Integer> func) {
        return biFunc.andThen(func).apply(x, y);
    }

    public static void main(String[] args) {
        System.out.println(BiFunctionTest.calc(2, 5, (x, y) -> x * y));
        System.out.println(BiFunctionTest.andThenCalc(2, 5, (x, y) -> x * y, y -> y * 2));
    }

}
