package tcbTongBu;

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

class Counter {
    public static final Object lock = new Object();
    public static volatile int count = 0;
    public static volatile int count1 = 0;
    public static volatile int sor = 0;
    public static volatile int Aj = 0;
    public static volatile int Bj = 0;
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
