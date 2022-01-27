package com.smec.streaM.reducE;

import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // 按行读取配置文件:
        List<String> props = Arrays.asList("profile=native", "debug=true", "logging=warn", "interval=500");

        Map<String, String> map = props.stream()
                // 把k=v转换为Map[k]=v:
                .map(kv -> {
                    String[] ss = kv.split("\\=", 2);
                    Map<String, String> x = new HashMap<String, String>();
                    x.put(ss[0], ss[1]);
                    return x;
                })
                // 把所有Map聚合到一个Map:
                .reduce(new HashMap<String, String>(), (m, kv) -> {
                    m.putAll(kv);
                    return m;
                });
        // 打印结果:
        map.forEach((k, v) -> {
            System.out.println(k + " = " + v);
        });
        for (String key : map.keySet()) {
            System.out.println(key + " = " + map.get(key));
        }
        System.out.println(map);
    }
}

