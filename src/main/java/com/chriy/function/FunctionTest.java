package com.chriy.function;

import java.util.function.Function;

/**
 * @author chriy
 * @version 1.0
 * @date 2020.02.25 10:58
 */
public class FunctionTest {
    /**
     * 创建一个简单的 function 例子
     */
     static void exampleOne(){
         Function<String,String> func = String::toUpperCase;
         System.out.println(func.apply("Hello"));
     }

    /**
     * 定义一个计算方法
     * @param a 需要计算的值
     * @param function 需要如何计算 ，lambda 表达式
     * @return 返回计算结果
     */
     public static int compute(int a ,Function<Integer,Integer> function){
         return function.apply(a);
     }

    /**
     * <h1>组合 Function 先算后面的操作,再算前面的操作</h1>
     * @param value 需要计算的值
     * @param beforeFunc 前一个 Function
     * @param afterFunc 后一个 Function
     * @return 计算结果
     */
     public static int compose(int value, Function<Integer,Integer> beforeFunc, Function<Integer,Integer> afterFunc){
         return beforeFunc.compose(afterFunc).apply(value);
     }

    /**
     * 链式连接 andThen  Function 按照参数传入的顺序,一个一个的执行
     * @param value 需要计算的值
     * @param beforeFunc 前一个 Function
     * @param afterFunc 后一个 Function
     * @return 计算结果
     */
    public static int andThen(int value, Function<Integer,Integer> beforeFunc, Function<Integer,Integer> afterFunc){
        return beforeFunc.andThen(afterFunc).apply(value);
    }

    public static void main(String[] args) {
        FunctionTest.exampleOne();
//        int compute = FunctionTest.compute(2, x -> x * 2 + 1);
//        System.out.println(compute);
        System.out.println(FunctionTest.compose(2, value -> value * 2, value -> value + 3));
        System.out.println(FunctionTest.andThen(2, value -> value * 2, value -> value + 3));
    }
}
