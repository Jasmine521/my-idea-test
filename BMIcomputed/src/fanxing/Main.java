package fanxing;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
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