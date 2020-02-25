package com.chriy.lambda;

/**
 * @author chriy
 * @version 1.0
 * @date 2020.02.25 10:05
 */
@FunctionalInterface
public interface FuncInterface {
    // 函数式接口
    void say();

    static void sayHello(){
        System.out.println("hello chriy");
    }
}
