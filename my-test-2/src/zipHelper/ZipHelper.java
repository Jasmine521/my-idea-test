package zipHelper;
import com.sun.org.apache.bcel.internal.generic.IFLE;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import static java.nio.file.Files.readAllBytes;

public class ZipHelper {
    public static void main(String[] args) throws IOException {
        String zipfile = "C:\\Users\\smec\\Desktop\\Desktop.zip";
        readZip(zipfile);
        String zipfileout = "C:\\Users\\smec\\Desktop\\wode1.zip";
        File in = new File("C:\\Users\\smec\\Desktop\\wode");
        File[] files = in.listFiles();
        createZip(zipfileout,files);
    }
    public static void readZip(String zipfile)throws IOException{
        try(ZipInputStream zip = new ZipInputStream(new FileInputStream(zipfile))){
            ZipEntry entry =null;
            while((entry=zip.getNextEntry())!=null){
                System.out.println(entry.getName());
                if(!entry.isDirectory()){
                    StringBuilder sb = new StringBuilder();
                    int n;
                    while ((n=zip.read())!=-1){
                        sb.append((char)n);
                    }
                    System.out.println(new String(sb.toString().getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));
                }
            }
        }
    }
    public static void createZip(String zipfile,File[] inputFiles)throws IOException{
        try(ZipOutputStream zip = new ZipOutputStream(new FileOutputStream(zipfile))){
            for(File file : inputFiles){
                if(file !=null&&file.exists()){
                    writeFileToZip(zip,file,"");
                }
            }
        }
    }
    public static void writeFileToZip(ZipOutputStream zip, File file, String prefix)throws IOException{
        if(file.exists()){
            if(file.isDirectory()){
                String entryName = prefix + file.getName()+"/";
                System.out.println("entryName:"+entryName);
                System.out.println("Path:"+ file.getCanonicalPath());
                zip.putNextEntry(new ZipEntry(entryName));
                File[] files = file.listFiles();
                if(files!=null){
                    for(File tmp : files){
                        writeFileToZip(zip,tmp,entryName);
                    }
                }
            }
            else {
                zip.putNextEntry(new ZipEntry(prefix+file.getName()));
                try(InputStream is = new FileInputStream(file)){
                    System.out.println("prefix:"+prefix+file.getName());
                    System.out.println("Path:"+ file.getCanonicalPath());

                    zip.write(readAllBytes(file.toPath()));
                }
            }
        }
    }

}





