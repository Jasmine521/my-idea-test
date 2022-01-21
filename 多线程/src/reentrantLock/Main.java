package reentrantLock;

import java.util.ConcurrentModificationException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock可以替代synchronized进行同步；
 * <p>
 * ReentrantLock获取锁更安全；
 * <p>
 * 必须先获取到锁，再进入try {...}代码块，最后使用finally保证释放锁；
 * <p>
 * 可以使用tryLock()尝试获取锁。
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();
        new Thread() {
            public void run() {
                for (int i = 1; i < 6; i++) {
                    c.add(i);
                    System.out.println(c.getCount());
                }
            }
        }.start();
        new Thread() {
            public void run() {
                for (int i = 1; i < 6; i++) {
                    try {
                        c.dec(i - 1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(c.getCount());
                }
            }
        }.start();
    }
}

class Counter {
    private final Lock lock;
    private final Condition condition;
    private int count;

    Counter() {
        lock = new ReentrantLock();
        condition = lock.newCondition();
    }

    private Queue<String> queue = new LinkedList<>();

    public void addTask(String s) {
        lock.lock();
        try {
            queue.add(s);
            condition.signalAll();      //唤醒等待中的进程
        } finally {
            lock.unlock();
        }
    }

    public String getTask() throws InterruptedException {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                condition.await();      //条件不足进入等待
            }
            return queue.remove();
        } finally {
            lock.unlock();
        }
    }

    public void add(int n) {
        lock.lock();
        try {
            count += n;
        } finally {
            lock.unlock();
        }
    }

    public void dec(int n) throws InterruptedException {
        if (lock.tryLock(1, TimeUnit.SECONDS)) {
            try {
                count -= n;
            } finally {
                lock.unlock();
            }
        }
    }

    public int getCount() {
        return count;
    }
}