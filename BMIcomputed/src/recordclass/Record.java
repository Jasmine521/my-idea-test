package recordclass;

import java.math.BigInteger;

public class Record {
    public static void main(String[] args) {
        BigInteger i = new BigInteger("123456789000");
        System.out.println(i.longValue()); // 123456789000
        System.out.println(i.multiply(i).longValueExact());
    }
}

