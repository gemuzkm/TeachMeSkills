package com.project.Calculator;

import java.util.ArrayList;

public class Store {
    private static ArrayList<String> list = new ArrayList<>();

    public static void addHistory(String inputDate)
    {
        list.add(inputDate);
    }

    public static void printHistory() {

        if (list.size() == 0) {
            System.out.println("\nИстория пуста\n");

        } else {
            System.out.println("\nИстория всех операций");
            for (String outHistoryDate : list) {
                System.out.println(outHistoryDate);
            }
            System.out.println("Вся история выведена\n");
        }
    }
}
