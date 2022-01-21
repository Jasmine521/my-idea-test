package readWriteLock;

import com.sun.webkit.dom.CounterImpl;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 使用ReadWriteLock可以提高读取效率：
 * <p>
 * ReadWriteLock只允许一个线程写入；
 * <p>
 * ReadWriteLock允许多个线程在没有写入时同时读取；
 * <p>
 * ReadWriteLock适合读多写少的场景。
 */
public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 9; i++) {
                    counter.inc(i);
                    System.out.println(Arrays.toString(counter.get()));
                }
            }
        }).start();
    }
}

class Counter {
    private final ReadWriteLock rwlock = new ReentrantReadWriteLock();
    private final Lock rlock = rwlock.readLock();
    private final Lock wlock = rwlock.writeLock();
    private int[] counts = new int[10];

    public void inc(int index) {
        wlock.lock(); // 加写锁
        wlock.lock();
        try {
            counts[index] += 1;
        } finally {
            wlock.unlock(); // 释放写锁
            wlock.unlock();
        }
    }

    public int[] get() {
        rlock.lock(); // 加读锁
        try {
            return Arrays.copyOf(counts, counts.length);
        } finally {
            rlock.unlock(); // 释放读锁
        }
    }
}