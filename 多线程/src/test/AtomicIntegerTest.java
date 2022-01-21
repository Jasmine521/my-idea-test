package test;

import java.util.concurrent.atomic.AtomicInteger;


public class AtomicIntegerTest extends Thread {

    private AtomicInteger atomicInteger;

    public AtomicIntegerTest(AtomicInteger atomicInteger) {
        this.atomicInteger = atomicInteger;
    }

    @Override
    public void run() {
        int i = atomicInteger.incrementAndGet();
        System.out.println("generated  out number:" + i);
    }

    public static void main(String[] args) {
        AtomicInteger counter = new AtomicInteger();
        for (int i = 0; i < 10; i++) {//10个线程
            System.out.println(counter);
            new AtomicIntegerTest(counter).start();
        }
    }
}