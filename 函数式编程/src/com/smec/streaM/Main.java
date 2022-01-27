package com.smec.streaM;

import java.io.IOException;
import java.math.BigInteger;
import java.util.function.LongSupplier;
import java.util.stream.Stream;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        LongStream fib = LongStream.generate(new FibSupplier());
        // 打印Fibonacci数列：1，1，2，3，5，8，13，21...
        fib.limit(10).forEach(System.out::println);
    }
}

class FibSupplier implements LongSupplier {
    long n = 1;
    long p = 0;
    long sum = 0;
    boolean flag = true;

    public long getAsLong() {
        if (flag) {
            flag = false;
            return 1;
        }
        sum = n + p;
        p = n;
        n = sum;
        return sum;
    }
}