package file;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\smec\\Desktop\\word.txt");
        System.out.println(File.separator);
        System.out.println(file);
        System.out.println(file.isFile() + " " + file.isDirectory());
        System.out.println("文件大小：" + file.length());
        File f = new File("C:\\Users\\smec\\Desktop\\werd.txt");
        if (f.createNewFile()) {
            System.out.println("文件创建成功");
            if (f.delete()) {
                System.out.println("文件删除成功");
            }
        }
        File f2 = new File("C:\\Windows");
        File f1 = File.createTempFile("tmp-", ".txt"); // 提供临时文件的前缀和后缀
        f1.deleteOnExit();

        File[] fs1 = f2.listFiles(); // 列出所有文件和子目录
        printFiles(fs1);
        File[] fs2 = f2.listFiles(new FilenameFilter() { // 仅列出.exe文件
            public boolean accept(File dir, String name) {
                return name.endsWith(".exe"); // 返回true表示接受该文件
            }
        });
        printFiles(fs2);
    }

    static void printFiles(File[] files) {
        System.out.println("==========");
        if (files != null) {
            for (File f : files) {
                System.out.println(f);
            }
        }
        System.out.println("==========");
    }
}
