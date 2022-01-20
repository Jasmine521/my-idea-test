package enCodeAndDeCode;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

public class Main {
    public static void main(String[] args) throws Exception, UnsupportedEncodingException {
        fun();
        fun1();
        fun2();
        fun3();
        //java.security包允许第三方提供无缝接入：Security.addProvider(xxx)
        //注册要用的第三方包，传入一个实例对象 new BouncyCastleProvider()
        KeyGenerator kGen =  KeyGenerator.getInstance("HmacMD5");
        SecretKey key = kGen.generateKey();
        byte[] bkey = key.getEncoded();//得到生成的key的编码
        System.out.println("bkey byte[]: "+Arrays.toString(bkey));
        System.out.println("bkey 16String: "+new BigInteger(1,bkey).toString(16));
        //算法
        Mac mac = Mac.getInstance("HmacMD5");
        mac.init(key);//把钥匙(salt 盐)传进去初始化
        //调用update读入信息的字节码
        mac.update("HelloWorld".getBytes("UTF-8"));
        //得到加了钥匙后的算法加密后的信息的字节码：
        byte[] result = mac.doFinal();
        //打印输出看看效果
        System.out.println("哈希后byte数组："+Arrays.toString(result));
        System.out.println("哈希后16String："+new BigInteger(1,result).toString(16)+"\n");
        //有了计算的哈希和SecretKey 想要验证时 SecretKey不能再从KeyGenerator生成，而是从byte[]数组里恢复
        SecretKey key2 = new SecretKeySpec(bkey, "HmacMD5");
        byte[] bkey2 = key2.getEncoded();
        System.out.println("bkey2 byte[]: "+ Arrays.toString(bkey2));
        System.out.println("bkey2 16String: "+new BigInteger(1,bkey2).toString(16));
        mac.init(key2);
        mac.update("HelloWorld".getBytes("UTF-8"));
        byte[] result2 = mac.doFinal();
        System.out.println("验证的哈希byte数组: "+Arrays.toString(result2));
        System.out.println("验证的哈希16String: "+new BigInteger(1,result2).toString(16));
    }
    static void  fun() throws UnsupportedEncodingException {
        String encoded = URLEncoder.encode("中 文!","UTF-8");
        System.out.println(encoded);

    }
    static void fun1() throws UnsupportedEncodingException {
        String decoded = URLDecoder.decode("%E4%B8%AD%E6%96%87%21", "UTF-8");
        System.out.println(decoded);
    }
    static void fun2(){
        byte[] input = new byte[] { (byte) 0xe4, (byte) 0xb8, (byte) 0xad, 0x21 };
        String b64encoded = Base64.getEncoder().encodeToString(input);
        String b64encoded2 = Base64.getEncoder().withoutPadding().encodeToString(input);
        System.out.println(b64encoded);
        System.out.println(b64encoded2);
        byte[] output = Base64.getDecoder().decode(b64encoded2);
        System.out.println(Arrays.toString(output));
    }
    static void fun3() throws UnsupportedEncodingException{
        byte[] input = new byte[] { (byte) 0xe4, (byte) 0xb8, (byte) 0xad };
        String b64encoded = Base64.getEncoder().encodeToString(input);
        System.out.println(b64encoded);
        byte[] output = Base64.getDecoder().decode("5Lit");
        System.out.println(Arrays.toString(output)); // [-28, -72, -83]
    }
}
