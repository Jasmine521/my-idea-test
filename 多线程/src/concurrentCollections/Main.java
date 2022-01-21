package concurrentCollections;

import java.util.Arrays;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.*;

/**
 * 线程安全Concurrent集合
 */
public class Main {
    public CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList();
    public Map<String, Integer> map = new ConcurrentHashMap<>();
    public Set<String> stringSet = new CopyOnWriteArraySet<>();
    public Queue<String> queue = new LinkedBlockingDeque<>(Arrays.asList(new String[]{"aa", "vv"}));
    public LinkedBlockingDeque<String> deque;

    public static void main(String[] args) {

    }
}
