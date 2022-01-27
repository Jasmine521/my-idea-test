package com.smec.LambdaTest.New;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * 字符串数组转List<String> ,再转List<Test*(自定义数据类型)>(使用实例构造函数),
 * 再将List<Test*(自定义数据类型)>转为数组，再调用sort(T[],compareTO<this , super T>)排序
 */
public class Main {
    public static void main(String[] args) {
        String[] array = new String[]{"Apple", "Orange", "Banana", "Lemon"};
        List<String> names = new ArrayList<String>(Arrays.stream(array).collect(Collectors.toList()));
        List<Test> tests = names.stream().map(Test::new).collect(Collectors.toList());
        Test t = new Test();
        System.out.println(tests);
        Test[] x = new Test[tests.size()];
        Arrays.sort(tests.toArray(x), Test::cmp);
        for (Test z : x)
            System.out.print(z + ", ");
        
    }

    static int cmp(String s1, String s2) {
        return s1.compareTo(s2);
    }
}

class Test {
    private String t;

    Test(String o) {
        this.t = o;
    }

    Test() {

    }

    public String getT() {
        return this.t;
    }

    @Override
    public String toString() {
        return "Test: " + t;
    }

    public int cmp(Test o) {
        return this.getT().toLowerCase(Locale.ROOT).compareTo(o.getT().toLowerCase(Locale.ROOT));
    }
}