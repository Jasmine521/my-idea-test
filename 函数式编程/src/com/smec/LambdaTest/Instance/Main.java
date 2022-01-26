package com.smec.LambdaTest.Instance;

import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        String[] array = new String[] { "Apple", "Orange", "Banana", "Lemon" };
        String s=null;
        Arrays.sort(array, String::compareTo);
        System.out.println(String.join(", ", array));
    }
}

