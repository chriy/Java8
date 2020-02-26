package com.chriy.supplier;

import java.util.function.Supplier;

/**
 * @author chriy
 * @version 1.0
 * @date 2020.02.26 19:09
 */
public class SupplierTest {

    public static void main(String[] args) {
        // 不接受参数,返回一个结果 类似于工厂制造对象一样
        Supplier<String> supplier = () -> "hello";
        System.out.println(supplier.get());
    }
}

