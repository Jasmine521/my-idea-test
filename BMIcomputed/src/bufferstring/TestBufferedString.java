package bufferstring;

import java.io.*;

public class TestBufferedString {

    public static void main(String[] args) throws Exception {
        // 指定要读取文件的缓冲输入字节流
        InputStream in = new BufferedInputStream(new FileInputStream("D:\\test.jpg"));
        File file = new File("D:\\test1.jpg");
        if (file != null) {
            file.createNewFile();
        }
        // 指定要写入文件的缓冲输出字节流
        OutputStream out = new BufferedOutputStream(new FileOutputStream(file));
        byte[] bb = new byte[1024];// 用来存储每次读取到的字节数组
        int n = 0;// 每次读取到的字节数组的长度
        while ((n = in.read(bb)) != -1) {
            reverse(bb);
            out.write(bb, 0, n);// 写入到输出流
        }
        out.close();// 关闭流
        in.close();
    }
    public static void reverse(byte[] bs){
        for(byte n : bs){
            n = (byte)(n+1) ;
        }

    }

}