package com.lesson13;

import java.time.LocalDate;
import java.time.LocalTime;

public class Study1 {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2020, 1, 12);
        System.out.println(localDate);

        LocalTime  localTime = LocalTime.now();
        System.out.println(localTime);
    }
}
