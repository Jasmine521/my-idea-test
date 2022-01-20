package fanxing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> strList = new ArrayList<String>();
        strList.add("hello"); // OK
        String s = strList.get(0); // OK
        System.out.println(s);
        List<String> list = new ArrayList<String>();
        list.add("Hello");
        list.add("World");
// 无强制转型:
        String first = list.get(0);
        String second = list.get(1);
        Pair<Integer> p = new Pair<>(123, 456);
// Compile error:
        if (p instanceof Pair) {
        }

        Pair[] ps = (Pair<String>[]) new Pair[2];
        ps[0] = new Pair<String>("a", "b");
        ps[1] = new Pair<String>("x", "y");
        Pair<String> p3 = ps[1];
        System.out.println(p3.getFirst() + " " + p3.getLast());
        Integer[] array = {1, 2, 3};
        List<Integer> list1 = Arrays.asList(array);
    }
}

class Par<T> {
    public boolean equals(Object t) {
        return this == t;
    }
}

class Pair<T> {
    private T first;
    private T last;

    public Pair(T first, T last) {
        this.first = first;
        this.last = last;
    }


    // 静态泛型方法应该使用其他类型区分:
    public static <K> Pair<K> create(K first, K last) {
        return new Pair<K>(first, last);
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getLast() {
        return last;
    }

    public void setLast(T last) {
        this.last = last;
    }
}