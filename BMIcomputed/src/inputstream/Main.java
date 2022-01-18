package inputstream;
import javafx.util.converter.CharacterStringConverter;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.format.FormatStyle;

public class Main {
    public static void main(String [] args) throws IOException {
        String s;
        try(InputStream in = new FileInputStream("C:\\Users\\smec\\Desktop\\word.txt")){
            s = readAsString(in);
        }


        System.out.println(s);

    }
    public static String readAsString(InputStream in) throws IOException{
        int n;
        StringBuilder res = new StringBuilder();
        while ((n=in.read())!=-1){
            res.append((char)n);
        }
        return new String(res.toString().getBytes("iso8859-1"),"UTF-8");
    }
}
