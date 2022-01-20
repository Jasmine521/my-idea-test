package writer;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        try (Writer writer = new FileWriter("C:\\Users\\smec\\Desktop\\word1.txt", true)) {
            writer.write('H');
            writer.write("Hello".toCharArray());
            writer.write("!泥嚎");
        }
        Writer w = new OutputStreamWriter(new FileOutputStream("C:\\Users\\smec\\Desktop\\ww.txt"), "utf-8");
        byte[] data = Files.readAllBytes(Paths.get("C:\\Users\\smec\\Desktop\\word1.txt"));
        System.out.println(new String(data));
        List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\smec\\Desktop\\word.txt"));
        Files.write(Paths.get("C:\\Users\\smec\\Desktop\\ww.txt"), lines);
    }
}
