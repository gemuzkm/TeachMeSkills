package com.lesson12;

import java.util.HashMap;
import java.util.HashSet;

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

        HashMap<String, Integer> map = new HashMap<>();

    }
}
