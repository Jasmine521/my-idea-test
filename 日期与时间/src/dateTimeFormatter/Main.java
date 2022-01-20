package dateTimeFormatter;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm", Locale.CHINA);
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("E M-d-yyyy HH:mm:ss", Locale.CHINA);
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(formatter.format(zonedDateTime));
        System.out.println(formatter1.format(zonedDateTime));
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(ldt));
        System.out.println(DateTimeFormatter.ISO_DATE_TIME.format(ldt));
    }
}
