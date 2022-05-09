package com.example.javachallenge;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

public class DaysFromNow {
    static LocalDate calcDays(LocalDate today) {
        Period tenDays = Period.ofDays(10);
        return today.plus(tenDays);
    }
    public static void main(String[] args) {
        LocalDate today = LocalDate.now(ZoneId.of("Europe/Paris"));
        System.out.println("10 days from now is... " + calcDays(today));
    }
}
