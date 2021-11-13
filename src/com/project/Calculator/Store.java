package com.project.Calculator;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private static List<String> list = new ArrayList<>();

    public void addHistory(String inputDate) {
        list.add(inputDate);
    }

    public void printHistory() {

        if (list.size() == 0) {
            System.out.println("\nИстория пуста\n");

        } else {
            System.out.println("\nИстория всех операций");
            for (String outHistoryData : list) {
                System.out.println(outHistoryData);
            }
            System.out.println("Вся история выведена\n");
        }
    }
}
