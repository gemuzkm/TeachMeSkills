package com.lesson12;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Main3 {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(2);
        set.remove(3);
        System.out.println(set.contains(1));
        System.out.println(set);

        System.out.println("MAP");
        HashMap<String, Integer> map = new HashMap<>();
        map.put("1", 100);
        map.put("2", 200);
        map.put("3", 300);
        System.out.println(map.get("2"));
        System.out.println(map.containsKey("2"));
        System.out.println(map);
        for (Map.Entry<String, Integer> i : map.entrySet()) {
            System.out.println(i);
        }

    }
}
