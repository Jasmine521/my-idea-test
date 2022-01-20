package mathclass;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

public class Main {
    public static <Booleann> void main(String[] args) {
        Math.abs(-100); // 100
        Math.abs(-7.8); // 7.8
        Math.max(100, 99); // 100
        Math.min(1.2, 2.3); // 1.2
        Math.pow(2, 10); // 2的10次方=1024
        Math.sqrt(2); // 1.414...
        Math.exp(2); // 7.389...
        Math.log(4); // 1.386...
        Math.log10(100); // 2
        Math.sin(3.14); // 0.00159...
        Math.cos(3.14); // -0.9999...
        Math.tan(3.14); // -0.0015...
        Math.asin(1.0); // 1.57079...
        Math.acos(1.0); // 0.0
        double pi = Math.PI; // 3.14159...
        double e = Math.E; // 2.7182818...
        Math.sin(Math.PI / 6); // sin(π/6) = 0.5

        SecureRandom sr = null;
        try {
            sr = SecureRandom.getInstanceStrong(); // 获取高强度安全随机数生成器
        } catch (NoSuchAlgorithmException e1) {
            sr = new SecureRandom(); // 获取普通的安全随机数生成器
        }
        byte[] buffer = new byte[16];
        sr.nextBytes(buffer); // 用安全随机数填充buffer
        System.out.println(Arrays.toString(buffer));
        int[] ints = new int[16];
        for (int i : ints)
            i = sr.nextInt();
        System.out.println(Arrays.toString(ints));
    }
}
