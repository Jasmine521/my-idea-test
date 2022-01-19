package reGeX;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String [] args){
        fun3();
    }

    /**
     * ?表示匹配一个或0个
     * 追加的? 表示非贪婪匹配  即在满足匹配条件的结果之中 寻找被?所修饰的匹配单元最短的结果
     */
    public static void fun4(){
        Pattern pattern = Pattern.compile("(\\d+?)(0*)");
        Matcher matcher = pattern.matcher("1230000");
        if (matcher.matches()) {
            System.out.println("group1=" + matcher.group(1)); // "123"
            System.out.println("group2=" + matcher.group(2)); // "0000"
        }
    }

    public static void fun3(){
        Pattern p = Pattern.compile("([01]?\\d|2[0-3])\\:([0-5]?\\d)\\:([0-5]?\\d)");
        Matcher m = p.matcher("23:9:56");
        if(m.matches()){
            String g1 = m.group(1);
            String g2 = m.group(2);
            String g3 = m.group(3);
            System.out.println("Hours:"+g1+"Minutes:"+g2+"Seconds:"+g3);
        }
    }
    public static void fun1(){
        Pattern p = Pattern.compile("(\\d{3,4})\\-(\\d{7,8})");
        Matcher m = p.matcher("010-12345678");
        if (m.matches()) {
            String g1 = m.group(1);
            String g2 = m.group(2);
            System.out.println(g1);
            System.out.println(g2);
        } else {
            System.out.println("匹配失败!");
        }

    }
    public static void fun2(){
        String s = "20\\\\\\d\\d";
        System.out.println("20\\42".matches(s));
        String re1 = "abc";
        System.out.println("abc".matches(re1));
        System.out.println("Abc".matches(re1));
        System.out.println("abcd".matches(re1));

        String re2 = "a.c\u548c"; // 对应的正则是a\&c
        System.out.println("a&c和".matches(re2));
        System.out.println("a-c".matches(re2));
        System.out.println("a&&c".matches(re2));
        String re3 = "\\s[^1-9]{3}";
        System.out.println(" 000".matches(re3));
    }
}
