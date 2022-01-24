package socket_UDP;

/**
 * 初始化的赋值语句一直赋值
 */
public class tesT {
    public static void main(String[] args) {
        fun2();
    }

    public static void fun1() {
        for (; ; ) {
            int i = 1;
            i++;
            if (i > 10) break;
            System.out.println(i);
        }
    }

    public static void fun2() {
        for (; ; ) {
            Integer a = new Integer(3);
            if (a.intValue() > 10) break;
            System.out.println(a.intValue());
            a++;
        }
    }
}

