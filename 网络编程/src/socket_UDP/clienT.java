package socket_UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

public class clienT {
    public static void main(String[] args) throws IOException, InterruptedException {
        DatagramSocket ds = new DatagramSocket();
        ds.setSoTimeout(1000);
        ds.connect(InetAddress.getByName("localhost"), 6666);
        DatagramPacket packet = null;
        for (int i = 0; i < 5; i++) {
            //send
            String cmd = new String[]{"data", "time", "datatime", "weather", "hello"}[i];
            byte[] data = cmd.getBytes(StandardCharsets.UTF_8);
            packet = new DatagramPacket(data, data.length);
            ds.send(packet);
            //receive
            byte[] buffer = new byte[1024];
            packet = new DatagramPacket(buffer, buffer.length);
            ds.receive(packet);
            String resp = new String(packet.getData(), packet.getOffset(), packet.getLength(), StandardCharsets.UTF_8);
            System.out.println(cmd + " >>> " + resp);
            Thread.sleep(1500);
        }
        ds.disconnect();
        System.out.println("disconnected.");
    }
}
