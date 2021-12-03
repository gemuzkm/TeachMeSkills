package com.lesson14;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Study2 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(7);
        list.add(5);
        list.add(0);
        list.add(4);
        list.add(8);
        list.add(0);
        list.add(8);
        list.add(7);


        List<Integer> newList = list.stream()
                .filter(value -> value % 2 ==0)
                .collect(Collectors.toList());
        System.out.println(newList);

        List<Integer> newList2 = list.stream()
                .skip(3)
                .filter(value -> value % 2 ==0)
                .collect(Collectors.toList());
        System.out.println(newList2);

        List<Integer> newList3 = list.stream()
                .skip(3)
                .limit(3)
                .filter(value -> value % 2 ==0)
                .collect(Collectors.toList());
        System.out.println(newList3);

        List<Integer> newlist4 = list.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(newlist4);

        long count = list.stream()
                .filter(value -> value % 2 ==0)
                .count();
        System.out.println(count);

        Optional<Integer> min = list.stream()
                .filter(value -> value % 2 == 0)
                .min(Integer::compareTo);

        min.ifPresent(System.out::println);

        list.stream()
                .forEach(value -> System.out.println(value));
    }
}
