package com.smec.streaM.fliteR;

import java.time.*;
import java.util.Random;
import java.util.function.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        Stream.generate(new LocalDateSupplier())
                .limit(31)
                .filter(ldt -> ldt.getHappysocre() >= 60)
                .forEach(System.out::println);
    }
}

class HappyDay {
    LocalDate day;
    int happysocre;

    HappyDay(LocalDate date, int happysocre) {
        this.day = date;
        this.happysocre = happysocre;
    }

    public int getHappysocre() {
        return happysocre;
    }

    public String toString() {

        return "DATE: " + day.toString() + "happySCORE: " + happysocre + "  " + day.getDayOfWeek();
    }
}

class LocalDateSupplier implements Supplier<HappyDay> {
    LocalDate start = LocalDate.of(2022, 1, 26);
    int n = -1;
    Random score;

    public HappyDay get() {
        n++;
        score = new Random();
        int s = score.nextInt(100);
        LocalDate starte = start.plusDays(n);
        if (starte.getDayOfWeek() == DayOfWeek.SUNDAY || starte.getDayOfWeek() == DayOfWeek.SATURDAY) {
            s = (s + 10) > 100 ? 100 : s + 10;
        }
        return new HappyDay(starte, s);
    }
}

