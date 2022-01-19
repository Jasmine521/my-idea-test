package instant;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.chrono.IsoChronology;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Main {
    public static void main(String[] args) {
        Instant now = Instant.now();
        System.out.println(now.getEpochSecond()); // 秒
        System.out.println(now.toEpochMilli()); // 毫秒
        long ti =  now.getEpochSecond();                                //instant  ->>    long
        System.out.println(ti);
        Instant now1 = Instant.ofEpochSecond((long) 1112225481);        ///long  -》  instant
        System.out.println(now1);
        ZoneId zi = ZoneId.ofOffset("GMT", ZoneOffset.ofHours(8));
        ZoneId.of("Asia/Shanghai");                                     // String ->ZoneId
        ZonedDateTime zdt = now1.atZone(ZoneId.systemDefault());        //instant ->>   ZonedDateTime
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("E y-M-d H:m:s", Locale.CHINESE);
        System.out.println("zdt"+fmt.format(zdt));
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        Instant instant = zonedDateTime.toInstant();                    //ZonedDateTime ->> instant
        System.out.println(now.toEpochMilli());
        System.out.println(fmt.format(zonedDateTime));

        // Date -> Instant:
        Instant ins1 = new Date().toInstant();

// Calendar -> Instant -> ZonedDateTime:
        Calendar calendar = Calendar.getInstance();
        Instant ins2 = calendar.toInstant();
        ZonedDateTime zdt1 = ins2.atZone(calendar.getTimeZone().toZoneId());

        // ZonedDateTime -> long:
        ZonedDateTime zdt2 = ZonedDateTime.now();
        long ts = zdt2.toEpochSecond() * 1000;

// long -> Date:
        Date date = new Date(ts);

// long -> Calendar:
        Calendar calendar1 = Calendar.getInstance();
        calendar1.clear();
        calendar1.setTimeZone(TimeZone.getTimeZone(zdt.getZone().getId()));
        calendar1.setTimeInMillis(zdt.toEpochSecond() * 1000);
    }
    static String timestampToString(long epochMilli, Locale lo, String zoneId) {
        Instant ins = Instant.ofEpochMilli(epochMilli);
        DateTimeFormatter f = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM, FormatStyle.SHORT);
        return f.withLocale(lo).format(ins.atZone(ZoneId.of(zoneId)));
    }
}
