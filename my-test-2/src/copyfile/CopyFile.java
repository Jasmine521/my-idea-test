package copyfile;

import java.io.*;

public class CopyFile {
    public static void main(String[] args) throws IOException {
        String inputpath = args[0];
        String ouputpath = args[1];
        byte[] buffer = new byte[1024];
        int n = 0;
        try (InputStream input = new FileInputStream(inputpath);
             OutputStream output = new FileOutputStream(ouputpath)) {
            while ((n = input.read(buffer)) != -1) {
                output.write(buffer, 0, n);
            }
        }
    }
}
