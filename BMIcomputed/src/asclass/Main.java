package asclass;

public class Main {
    public static void main(String[] args) {
        int i = 100;
        Integer n1 = new Integer(i);
        Integer n2 = Integer.valueOf(i);
        Integer n3 = Integer.valueOf("111");
        System.out.println(n3.intValue() + " n2:" + n2.intValue() + " n1:" + n1.intValue() + " " + Integer.valueOf(i));
        System.out.println("n1 == n2:" + (n1 == n2));
        System.out.println("n1.euqals(n2):" + (n1.equals(n2)));
        int x2 = Integer.parseInt("100", 16);
        int x3 = Integer.valueOf("100", 16);
        System.out.println("x2,x3:" + x2 + ";" + x3);
        System.out.println(Integer.toString(100)); // "100",表示为10进制
        System.out.println(Integer.toString(100, 36)); // "2s",表示为36进制
        System.out.println(Integer.toHexString(100)); // "64",表示为16进制
        System.out.println(Integer.toOctalString(100)); // "144",表示为8进制
        System.out.println(Integer.toBinaryString(100)); // "1100100",表示为2进制
        System.out.println();
        // boolean只有两个值true/false，其包装类型只需要引用Boolean提供的静态字段:
        Boolean t = Boolean.TRUE;
        Boolean f = Boolean.FALSE;
// int可表示的最大/最小值:
        int max = Integer.MAX_VALUE; // 2147483647
        int min = Integer.MIN_VALUE; // -2147483648
// long类型占用的bit和byte数量:
        int sizeOfLong = Long.SIZE; // 64 (bits)
        int bytesOfLong = Long.BYTES; // 8 (bytes)
        System.out.println();
        Number num = new Integer(999);
// 获取byte, int, long, float, double:
        byte b = num.byteValue();
        int n = num.intValue();
        long ln = num.longValue();
        float f1 = num.floatValue();
        double d = num.doubleValue();
        byte x = -1;
        byte y = 127;
        System.out.println(Byte.toUnsignedInt(x)); // 255
        System.out.println(Byte.toUnsignedInt(y)); // 127
    }
}

class Person {
    private String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}