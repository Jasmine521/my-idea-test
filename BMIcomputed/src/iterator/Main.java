package iterator;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ReverseList<String> rlist = new ReverseList<>();
        rlist.add("Apple");
        rlist.add("Orange");
        rlist.add("Pear");
        for (String s : rlist) {
            System.out.println(s);
        }
        List<String> list2 = Collections.emptyList();
    }
}

//实现iterable
class ReverseList<T> implements Iterable<T> {

    @Override
    public Iterator<T> iterator() {
        return new ReverseIterator(list.size());
    }

    private List<T> list = new ArrayList<>();

    public void add(T t) {
        list.add(t);
    }

    class ReverseIterator implements Iterator<T> {
        int index;

        ReverseIterator(int index) {
            this.index = index;
        }

        @Override
        public boolean hasNext() {
            return index > 0;
        }

        @Override
        public T next() {
            index--;
            return ReverseList.this.list.get(index);
        }
    }
}