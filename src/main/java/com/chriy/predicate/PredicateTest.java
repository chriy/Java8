package com.chriy.predicate;

import java.util.function.Predicate;

/**
 * @author chriy
 * @version 1.0
 * @date 2020.02.25 23:48
 */
public class PredicateTest {

    public static void main(String[] args) {

        Predicate<String> predicate = value -> value.length() > 5;
        System.out.println(predicate.test("B"));
    }

}
