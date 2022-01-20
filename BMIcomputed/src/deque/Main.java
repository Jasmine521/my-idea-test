package deque;

import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();
        deque.offerLast("A");
        deque.offerLast("B");
        deque.offerFirst("C");
        System.out.println(deque.pollFirst());//C       A - > B
        System.out.println(deque.pollLast());//B        A
        System.out.println(deque.pollFirst());//A
        System.out.println(deque.pollFirst());
    }

}
