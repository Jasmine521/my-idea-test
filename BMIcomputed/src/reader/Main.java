package reader;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\smec\\Desktop\\word.txt";
        Reader reader = new FileReader(path);int cnt = 0;
        Reader r = new InputStreamReader(new FileInputStream(path),StandardCharsets.UTF_8);

        CharArrayReader reader1 = new CharArrayReader("woa".toCharArray());
        while(true){
            int n = reader.read();

            if(n==-1){
                break;
            }
            cnt++;
            System.out.println(cnt+":"+(char) n);
        }
        reader.close();

        readFile(path);
    }
    public static void readFile(String file) throws IOException{
        try(Reader reader= new FileReader(file)){
            char[] buffer = new char[1000];
            int n;
            while ((n=reader.read(buffer))!=-1){
                System.out.println("read"+n+"chars");
            }
        }
    }
}
