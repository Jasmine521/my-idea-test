package future;

import javax.xml.crypto.Data;
import java.security.interfaces.RSAKey;
import java.util.concurrent.*;

/**
 * 当我们提交一个Callable任务后，我们会同时获得一个Future对象，然后，我们在主线程某个时刻调用Future对象的get()方法，就可以获得异步执行的结果。在调用get()时，如果异步任务已经完成，我们就直接获得结果。如果异步任务还没有完成，那么get()会阻塞，直到任务完成后才返回结果。
 *
 * 一个Future<V>接口表示一个未来可能会返回的结果，它定义的方法有：
 *
 * get()：获取结果（可能会等待）
 * get(long timeout, TimeUnit unit)：获取结果，但只等待指定的时间；
 * cancel(boolean mayInterruptIfRunning)：取消当前任务；
 * isDone()：判断任务是否已完成。
 */
public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(4);
        Callable<String> cab = new Task();
        Future<String> future = es.submit(cab);
        String result = future.get();
        future.isDone();
        System.out.println(result);
    }
}

class Task implements Callable<String> {
    @Override
    public String call() throws Exception {
        return longTimeCalculation();
    }

    private String longTimeCalculation() {
        return new Long(System.currentTimeMillis()).toString();
    }

}
