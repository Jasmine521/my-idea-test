package zifuchuan;

import java.nio.charset.StandardCharsets;

import static org.apache.commons.lang.StringUtils.*;

public class Main {
    public static void main(String[] args){
        final  String x="Hello";
        boolean y = "Hello".contains("ll");
        int y1 = x.indexOf("l");
        int y2 = x.lastIndexOf("l");
        y = x.startsWith("He");
        y = x.endsWith("lo");

        String s = x.substring(2);
        String s1 = x.substring(2,4);

        boolean xz = isBlank("\u3000Hello\u3000");
        String s2 = strip("\u3000Hello\u3000");
        s2 = stripStart("\u3000Hello\u3000",(String)null);
        s2 = stripEnd("\u3000Hello\u3000",(String)null);
        s2.isEmpty();
        xz = isBlank("                \n\t");
        s1 = x.replace('e','x');
        s2 = replace(x,"l","www");
        String s3 = "A,,B;C ,D";
        s3.replaceAll("[\\,\\;\\s]+",",");
        String[] ss = s3.split("\\,");
        String s4 = String.join("+++",ss);
        byte[] b1 = "1AHello".getBytes(StandardCharsets.UTF_8);
        for(byte n:b1)
        System.out.println(n);
        String s5 = new String(b1,StandardCharsets.UTF_8);
        System.out.println(s5);


    }

}
