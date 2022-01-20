package reGeX;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        fun8();
    }

    /**
     * appendReplacement是java中替换相应字符串的一个方法
     * appendReplacement(StringBuffer sb,String replacement)
     * 将当前匹配子串替换为指定字符串，并且将替换后的子串以及其之前到上次匹配子串之后的字符串段添加到一个 StringBuffer 对象里
     * appendTail(StringBuffer sb)
     * 将最后一次匹配工作后剩余的字符串添加到一个 StringBuffer 对象里
     */
    public static void fun8() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Bob");
        map.put("lang", "Java");
        Pattern p = Pattern.compile("\\$\\{([\\w]+)\\}");
        Matcher m = p.matcher("Hello, ${name}! You are learning ${lang}!");
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            System.out.println(m.group(1));
            m.appendReplacement(sb, map.get(m.group(1)));
        }
        m.appendTail(sb);
        System.out.println(sb.toString());

    }

    public static void fun7() {
        String s = "The     quick\t\t brown   fox  jumps   over the  lazy dog.";
        String r = s.replaceAll("\\s+", " ");
        System.out.println(r); // "The quick brown fox jumps over the lazy dog."
    }

    public static void fun6() {
        String s = "the quick brown fox jumps over the lazy dog.";
        Pattern p = Pattern.compile("\\wo\\w");
        Matcher m = p.matcher(s);
        while (m.find()) {
            String sub = s.substring(m.start(), m.end());
            System.out.println(sub);
        }
    }

    public static void fun5() {
        System.out.println(Arrays.toString("a b c".split("\\s")));
        System.out.println(Arrays.toString("a b  c".split("\\s")));
        System.out.println(Arrays.toString("a b , ; c".split("[\\,\\;\\s]+")));
    }

    /**
     * ?表示匹配一个或0个
     * 追加的? 表示非贪婪匹配  即在满足匹配条件的结果之中 寻找被?所修饰的匹配单元最短的结果
     */
    public static void fun4() {
        Pattern pattern = Pattern.compile("(\\d+?)(0*)");
        Matcher matcher = pattern.matcher("1230000");
        if (matcher.matches()) {
            System.out.println("group1=" + matcher.group(1)); // "123"
            System.out.println("group2=" + matcher.group(2)); // "0000"
        }
    }

    public static void fun3() {
        Pattern p = Pattern.compile("([01]?\\d|2[0-3])\\:([0-5]?\\d)\\:([0-5]?\\d)");
        Matcher m = p.matcher("23:9:56");
        if (m.matches()) {
            String g1 = m.group(1);
            String g2 = m.group(2);
            String g3 = m.group(3);
            System.out.println("Hours:" + g1 + "Minutes:" + g2 + "Seconds:" + g3);
        }
    }

    public static void fun1() {
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

    public static void fun2() {
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
