package com.project.Calculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Store {
    private static List<String> list = new ArrayList<>();
    private static Map<String, String> mapLoginPass = new HashMap<>();

    public void addNewUser(String userName, String userPass) {
        mapLoginPass.put(userName, userPass);
    }

    public boolean сheckUser(String userName) {
        return mapLoginPass.containsKey(userName) ? true : false;
    }

    public boolean сheckUserPass(String userName, String userPass) {
        String mapUserPass;
        mapUserPass = mapLoginPass.get(userName);
        if (mapUserPass.equals(userPass)) {
            return true;
        } else {
            return false;
        }
    }

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
