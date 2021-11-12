package com.project;

import java.util.ArrayList;

public class History {
    private static ArrayList<String> list = new ArrayList<>();

    public static void addHistory(String inputDate)
    {
        list.add(inputDate);
    }

    public static void printHistory() {
        System.out.println("\nИстория всех операций");
        for (String outHistoryDate : list) {
            System.out.println(outHistoryDate);
        }
        System.out.println("Вся история выведена\n");
    }
}
