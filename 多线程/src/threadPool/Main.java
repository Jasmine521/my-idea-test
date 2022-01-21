package threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import java.util.concurrent.*;

/**
 * FixedThreadPool：线程数固定的线程池；
 * CachedThreadPool：线程数根据任务动态调整的线程池；
 * SingleThreadExecutor：仅单线程执行的线程池。
 * 创建这些线程池的方法都被封装到Executors这个类中。
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        // 创建一个固定大小的线程池:
        ExecutorService es = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 6; i++) {
            es.submit(new Task("" + i));
        }
        // 关闭线程池:用shutdown()方法关闭线程池的时候，它会等待正在执行的任务先完成，然后再关闭。
        // shutdownNow()会立刻停止正在执行的任务，awaitTermination()则会等待指定的时间让线程池关闭。
        // es.shutdown();
        es.awaitTermination(1000, TimeUnit.MILLISECONDS);

        //创建一个动态大小的线程池
        int min = 4;
        int max = 10;
        ExecutorService esv = new ThreadPoolExecutor(min, max,
                60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
        //放入ScheduledThreadPool的任务可以定期反复执行。
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(4);

        // 1秒后执行一次性任务:
        ses.schedule(new Task("one-time"), 1, TimeUnit.SECONDS);
        // 2秒后开始执行定时任务，每3秒执行:                   实时的定时任务
        ses.scheduleAtFixedRate(new Task("fixed-rate"), 2, 3, TimeUnit.SECONDS);
        // 2秒后开始执行定时任务，以3秒为间隔执行:                上一个任务结束后开始记时的延时任务
        ses.scheduleWithFixedDelay(new Task("fixed-delay"), 2, 3, TimeUnit.SECONDS);
    }
}

/**
 * Java标准库还提供了一个java.util.Timer类，这个类也可以定期执行任务，
 * 但是，一个Timer会对应一个Thread，所以，一个Timer只能定期执行一个任务，多个定时任务必须启动多个Timer，
 * 而一个ScheduledThreadPool就可以调度多个定时任务，所以，我们完全可以用ScheduledThreadPool取代旧的Timer。
 */
class Task implements Runnable {
    private final String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("start task " + name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        System.out.println("end task " + name);
    }
}

