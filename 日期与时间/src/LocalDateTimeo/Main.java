package LocalDateTimeo;

import org.omg.CORBA.TIMEOUT;

import java.time.*;
import java.time.temporal.TemporalAdjusters;

/**
 * 本地日期和时间：LocalDateTime，LocalDate，LocalTime；
 * 带时区的日期和时间：ZonedDateTime；
 * 时刻：Instant；
 * 时区：ZoneId，ZoneOffset；
 * 时间间隔：Duration。
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        LocalDate d = LocalDate.now(); // 当前日期
        LocalTime t = LocalTime.now(); // 当前时间
        //Thread.sleep((long) (1000));
        LocalDateTime dt = LocalDateTime.now(); // 当前日期和时间
        System.out.println(d); // 严格按照ISO 8601格式打印
        System.out.println(t); // 严格按照ISO 8601格式打印
        System.out.println(dt); // 严格按照ISO 8601格式打印
        LocalDate date = LocalDate.of(2023, 12, 30);
        LocalTime time = LocalTime.of(14, 9, 31, 053);
        LocalDateTime dateTime = LocalDateTime.of(2027, 1, 2, 9, 14, 2, 122);
        LocalDateTime dateTime1 = LocalDateTime.of(date, time);
        System.out.println(dateTime);
        System.out.println(dateTime1);
        dt = LocalDateTime.parse("2019-11-19T15:16:17.000215");
        LocalDate firstWeekday = LocalDate.now().with(TemporalAdjusters.firstDayOfYear());
        firstWeekday = firstWeekday.with(TemporalAdjusters.firstInMonth(DayOfWeek.FRIDAY));
        System.out.println(firstWeekday);
        durationAndPeriod();
    }

    public static void durationAndPeriod() {
        LocalDateTime start = LocalDateTime.of(2019, 11, 19, 8, 15, 0);
        LocalDateTime end = LocalDateTime.of(2020, 1, 9, 19, 25, 30);
        Duration d = Duration.between(start, end);
        System.out.println(d); // PT1235H10M30S

        Period p = LocalDate.of(2019, 11, 19).until(LocalDate.of(2020, 1, 9));
        System.out.println(p); // P1M21D
    }

}
