package com.chriy.optional;

import java.util.Optional;

/**
 * @author chriy
 * @version 1.0
 * @date 2020.02.27 00:14
 */
public class OptionalTest {

    public static void main(String[] args) {

        Optional<String> optional = Optional.of("hello");
        // 定义一个可能为空的对象容器
        //Optional<String> optional = Optional.ofNullable(value);

        // 构造值为 null 的容器
        Optional<Object> empty = Optional.empty();

        // orElse 如果容器中的值为空 则显示other 的数据,反之显示容器中的数据
        System.out.println(empty.orElse("World"));

        // 通常情况使用这种方法替代 if 判断
        optional.ifPresent(System.out::println);

        // map 将容器中的值转为大写后再输出
        System.out.println(optional.map(String::toUpperCase).get());

        System.out.println("==========");
        // orElseGet 如果 容器为空,就使用 供给参数创建一个对象
        User user = (User) empty.orElseGet(User::new);
        System.out.println(user.getName());


        // 过滤 容器中的值是否长度大于 5 ,是就输出,不是则返回 empty
        optional.filter(value -> value.length() > 5)
            .ifPresent(System.out::println);
    }
}

class User {
    String name = "张三";

    public String getName() {
        return name;
    }
}
