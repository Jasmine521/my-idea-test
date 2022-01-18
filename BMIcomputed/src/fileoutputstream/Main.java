package fileoutputstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws IOException {
        try (OutputStream out = new FileOutputStream("C:\\Users\\smec\\Desktop\\word.txt",true)){
            out.write("Hello,三零六！\n".getBytes(StandardCharsets.UTF_8));
            out.write("\n".getBytes());
        }


    }
}
