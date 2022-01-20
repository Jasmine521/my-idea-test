package xuliehua;

import com.sun.javafx.tk.TKPulseListener;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        byte[] bytes = new byte[1024];

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try (ObjectOutputStream output = new ObjectOutputStream(outputStream)
        ) {
            output.writeInt(12345);
            output.writeUTF("Hello");
            output.writeObject(Double.valueOf(123.456));
            System.out.println(Arrays.toString(outputStream.toByteArray()));
            bytes = outputStream.toByteArray();

        }
        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
        try (ObjectInputStream input = new ObjectInputStream(inputStream)) {
            int n = input.readInt();
            String s = input.readUTF();
            Double d = (Double) input.readObject();
            System.out.println("" + n + s + d);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
