package tcbTongBu;

/**
 * 用synchronized修饰方法可以把整个方法变为同步代码块，synchronized方法加锁对象是this；
 * <p>
 * 通过合理的设计和数据封装可以让一个类变为“线程安全”；
 * <p>
 * 一个类没有特殊说明，默认不是thread-safe；
 * <p>
 * 多线程能否安全访问某个非线程安全的实例，需要具体问题具体分析。
 */
public class Main {
    public static void main(String[] args) throws Exception {
        AddThread add = new AddThread();
        DecThread dec = new DecThread();
        add.start();
        dec.start();
        add.join();
        dec.join();
        System.out.println(Counter.count);
        System.out.println(Counter.count1);
    }
}

class Pair {
    public int first;
    public int last;
}

class Counter {
    public static final Object lock = new Object();
    public static volatile int count = 0;
    public static volatile int count1 = 0;
    public static volatile int sor = 0;
    public static volatile int Aj = 0;
    public static volatile int Bj = 0;

    public void add(int n) {
        synchronized (this) {       //线程安全的方法
            count += n;
        }
    }

    public synchronized void add1(int n) {      //线程安全的方法

        count += n;

    }

    public void dec(int n) {
        synchronized (this) {
            count -= n;
        }
    }

    public int get() {
        return count;
    }

    private int first;
    private int last;

    public Pair getpair() {
        Pair p = new Pair();
        p.first = first;
        p.last = last;
        return p;
    }
}

class AddThread extends Thread {
    public void run() {
        for (int i = 0; i < 10000; i++) {

            /**
             * peterson锁
             */
            Counter.Aj = 1;
            Counter.sor = 1;

            while ((Counter.sor == 1 && Counter.Bj == 1)) {

            }
            Counter.count += 1;
            Counter.Aj = 0;
/**
 * synchronized(lock) {//持有
 *      //code
 * }//释放
 * 执行一个mutex的持有和释放
 */
            synchronized (Counter.lock) {
                Counter.count1 += 1;
            }

        }
    }
}

class DecThread extends Thread {
    public void run() {
        for (int i = 0; i < 10000; i++) {
            Counter.Bj = 1;
            Counter.sor = 2;
            while (Counter.sor == 2 && Counter.Aj == 1) {

            }
            Counter.count -= 1;
            Counter.Bj = 0;

            synchronized (Counter.lock) {
                Counter.count1 -= 1;
            }

        }
    }
}
