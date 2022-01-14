package recordclass;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.Format;

public class Record {
    public static void main(String[] args) {
        BigInteger i = new BigInteger("123456789000");
        System.out.println(i.longValue()); // 123456789000
//        System.out.println(i.multiply(i).longValueExact());
        BigDecimal bd = new BigDecimal("123.4567");
        System.out.println(bd.pow((int) 5)); // 15241.55677489
        BigDecimal d1 = new BigDecimal("123.4500");
        BigDecimal d2 = d1.stripTrailingZeros();
        System.out.println(d1+" "+d1.scale()); // 4
        System.out.println(d2+" "+d2.scale()); // 2,因为去掉了00

        BigDecimal d3 = new BigDecimal("1234500");
        BigDecimal d4 = d3.stripTrailingZeros();
        System.out.println(d3+" "+d3.scale()); // 0
        System.out.println(String.format("d4:%f  and d4:",d4)+d4+" "+ d4.scale()); // -2

        BigDecimal n = new BigDecimal("12.75");
        BigDecimal m = new BigDecimal("0.15");
        BigDecimal[] dr = n.divideAndRemainder(m);
        if (dr[1].signum() == 0) {
            //
            System.out.println(" n是m的整数倍");
        }
    }
}

