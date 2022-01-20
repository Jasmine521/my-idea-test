package math;

import java.math.*;

public class MathMethod {
    public static void main(String[] args) {

        BigInteger bigInteger = new BigInteger(String.valueOf((int) Math.pow(2, 16)));
        System.out.println(bigInteger.intValue());
    }
}
