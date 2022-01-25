package com.smec.LambdaTest;

import java.util.Arrays;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        String[] strings = new String[]{"apple", "banana", "Orange", "Apple", "pair", "Banana"};
        Arrays.sort(strings, (s1, s2) -> s1.toLowerCase(Locale.ROOT).compareTo(s2.toLowerCase(Locale.ROOT)));
        System.out.println(String.join(", ", strings));
    }
}
