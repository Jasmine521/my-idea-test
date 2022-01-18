package DataAndCalendar.date;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args){
        long t = System.currentTimeMillis();
        Date date = new Date();
        System.out.println(date.toString());
        System.out.println(date.toGMTString());
        System.out.println(date.toLocaleString());
        Format sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        System.out.println(sdf.format(date));
    }
}
