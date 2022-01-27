package com.smec.streaM.maP;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * stream的乾坤大挪移  C语言看了直呼受不了
 */
public class Main {
    static int n = 0;

    public static void main(String[] args) {
        Stream<String> stream = Stream.of("2019-11-19T15:16:17.000215",
                "2019-11-19T15:16:17.000215", "2019-11-19T15:16:17.000215",
                "2019-11-19T15:16:17.000215", "2019-11-19T15:16:17.000215");
        stream.map(LocalDateTime::parse).limit(5).map(LocalDateTime::toLocalDate)
                .map(LocalDate::atStartOfDay).map(Main::plsa).forEach(System.out::println);
        LocalDateTime dateTime = LocalDateTime.now();
        dateTime.plusHours(2);


    }

    static LocalDateTime plsa(LocalDateTime in) {
        n++;
        LocalDateTime mm = in.plusHours(n);
        return mm;
    }
}
