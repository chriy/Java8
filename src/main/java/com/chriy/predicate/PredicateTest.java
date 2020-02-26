package com.chriy.predicate;

import java.util.List;
import java.util.function.Predicate;

/**
 * @author chriy
 * @version 1.0
 * @date 2020.02.25 23:48
 */
public class PredicateTest {

    /**
     * 条件判断,筛选出 满足 条件的结果
     *
     * @param list      元素集合
     * @param predicate 需要筛选的条件
     */
    public static void conditionFilter(List<Integer> list, Predicate<Integer> predicate) {
        list.forEach(item -> {
            if (predicate.test(item)) {
                System.out.println(item);
            }
        });
    }

    /**
     * 条件判断,筛选出 满足 条件的结果
     * 逻辑与
     *
     * @param list       元素集合
     * @param predicate1 需要筛选的条件 1
     * @param predicate2 需要筛选的条件 2
     */
    public static void andConditionFilter(List<Integer> list,
                                          Predicate<Integer> predicate1,
                                          Predicate<Integer> predicate2) {
        list.forEach(item -> {
            if (predicate1.and(predicate2).test(item)) {
                System.out.println(item);
            }
        });
    }

    /**
     * 反向筛选结果
     * 逻辑取反
     *
     * @param list      元素集合
     * @param predicate 需要筛选的条件
     */
    public static void negateConditionFilter(List<Integer> list, Predicate<Integer> predicate) {
        list.forEach(item -> {
            //对给定的条件取反
            if (predicate.negate().test(item)) {
                System.out.println(item);
            }
        });
    }

    /**
     * 逻辑或
     *
     * @param list       元素集合
     * @param predicate1 需要筛选的条件 1
     * @param predicate2 需要筛选的条件 2
     */
    public static void orConditionFilter(List<Integer> list,
                                         Predicate<Integer> predicate1,
                                         Predicate<Integer> predicate2) {
        list.forEach(item -> {
            if (predicate1.or(predicate2).test(item)) {
                System.out.println(item);
            }
        });
    }

    public static void main(String[] args) {
//        Predicate<String> predicate = value -> value.length() > 5;
//        System.out.println(predicate.test("B"));

        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        PredicateTest.conditionFilter(list, value -> value > 5);
//        PredicateTest.andConditionFilter(list, value -> value > 2, value -> value < 5);

//        PredicateTest.negateConditionFilter(list, value -> value > 5);
        PredicateTest.orConditionFilter(list, value -> value > 5, value -> value % 2 == 0);
        System.out.println("=================");
        PredicateTest.orConditionFilter(list, value -> value % 2 == 0, value -> value > 5);
    }
}
