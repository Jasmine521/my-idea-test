package com.smec.LambdaTest;

import java.util.Arrays;
import java.util.Locale;

/**
 * FunctionalInterface允许传入：
 * <p>
 * 接口的实现类（传统写法，代码较繁琐）；
 * Lambda表达式（只需列出参数名，由编译器推断类型）；
 * 符合方法签名的静态方法；
 * 符合方法签名的实例方法（实例类型被看做第一个参数类型）；
 * 符合方法签名的构造方法（实例类型被看做返回类型）。
 * FunctionalInterface不强制继承关系，不需要方法名称相同，只要求方法参数（类型和数量）与方法返回类型相同，即认为方法签名相同。
 */
public class Main {
    public static void main(String[] args) {
        String[] strings = new String[]{"apple", "banana", "Orange", "Apple", "pair", "Banana"};
        Arrays.sort(strings, (s1, s2) -> s1.toLowerCase(Locale.ROOT).compareTo(s2.toLowerCase(Locale.ROOT)));
        System.out.println(String.join(", ", strings));
    }
}
