package HTTPurl;

import com.sun.deploy.net.HttpRequest;
import sun.net.www.http.HttpClient;

import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Learn Java from https://www.liaoxuefeng.com/
 *
 * @author liaoxuefeng
 */
public class Main {

    //  static HttpClient httpClient = HttpClient.newBuilder().build();

    public static void main(String[] args) throws Exception {
//        httpGet("https://www.sina.com.cn/");
//        httpPost("https://accounts.douban.com/j/mobile/login/basic",
//                "name=bob%40example.com&password=12345678&remember=false&ck=&ticket=");
//        httpGetImage("https://img.t.sinajs.cn/t6/style/images/global_nav/WB_logo.png");

        URL url = new URL("https://www.sina.com.cn/");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setUseCaches(false);
        conn.setConnectTimeout(5000);

        conn.setRequestProperty("Accept", "*/*");
        conn.setRequestProperty("User-Agent", "Mozilla/5.0 (compatible: MSIE 11; Windows NT 5.1)");

        conn.connect();
        System.out.println("Running...");
        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("bad response");
        }

        Map<String, List<String>> map = conn.getHeaderFields();
        for (String key : map.keySet()) {
            System.out.println((key + ": " + map.get(key)));
        }
        InputStream input = conn.getInputStream();
        Reader reader = new InputStreamReader(input);
        int n = 0, cnt = 0;
        StringBuffer stringBuffer = new StringBuffer();
        char[] chars = new char[1000];

        while ((n = reader.read(chars, 0, 1000)) != -1) {
            stringBuffer.append(chars, 0, n);
            System.out.println("receive chars : " + n);
            cnt += n;
        }
        OutputStream outputStream = new FileOutputStream("C:\\Users\\smec\\IdeaProjects\\my-test\\网络编程\\src\\HTTPurl\\sina.txt");
        try (Writer writer = new OutputStreamWriter(outputStream,StandardCharsets.UTF_8)) {
            writer.write(stringBuffer.toString());
            writer.write("hello");
        }
        System.out.println("Total receive chars : "+cnt);
        System.out.println("End...");
//        System.out.println(stringBuffer.toString());
    }

//    static void httpGet(String url) throws Exception {
//        HttpRequest request = HttpRequest.newBuilder(new URI(url))
//                // 设置Header:
//                .header("User-Agent", "Java HttpClient").header("Accept", "*/*")
//                // 设置超时:
//                .timeout(Duration.ofSeconds(5))
//                // 设置版本:
//                .version(Version.HTTP_2).build();
//        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
//        System.out.println(response.body().substring(0, 1024) + "...");
//    }
//
//    static void httpGetImage(String url) throws Exception {
//        HttpRequest request = HttpRequest.newBuilder(new URI(url))
//                // 设置Header:
//                .header("User-Agent", "Java HttpClient").header("Accept", "*/*")
//                // 设置超时:
//                .timeout(Duration.ofSeconds(5))
//                // 设置版本:
//                .version(Version.HTTP_2).build();
//        HttpResponse<InputStream> response = httpClient.send(request, HttpResponse.BodyHandlers.ofInputStream());
//        // 显示Http返回的图片:
//        BufferedImage img = ImageIO.read(response.body());
//        ImageIcon icon = new ImageIcon(img);
//        JFrame frame = new JFrame();
//        frame.setLayout(new FlowLayout());
//        frame.setSize(200, 100);
//        JLabel lbl = new JLabel();
//        lbl.setIcon(icon);
//        frame.add(lbl);
//        frame.setVisible(true);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    }
//
//    static void httpPost(String url, String body) throws Exception {
//        HttpRequest request = HttpRequest.newBuilder(new URI(url))
//                // 设置Header:
//                .header("User-Agent", "Mozilla/5.0 (compatible, MSIE 11, Windows NT 6.3; Trident/7.0) like Gecko")
//                .header("Accept", "*/*").header("Content-Type", "application/x-www-form-urlencoded")
//                // 设置超时:
//                .timeout(Duration.ofSeconds(5))
//                // 设置版本:
//                .version(Version.HTTP_2)
//                // 使用POST并设置Body:
//                .POST(BodyPublishers.ofString(body, StandardCharsets.UTF_8)).build();
//        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
//        System.out.println(response.body());
//    }

}
