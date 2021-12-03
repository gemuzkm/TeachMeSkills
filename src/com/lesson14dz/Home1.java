package com.lesson14dz;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

public class Home1 {
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            list.add(random.nextInt(100));
        }
        System.out.println("Сделать список целых чисел, заполнить рандомными значениями.");
        System.out.println(list);


        long count = list.stream()
                .filter(value -> value % 2 == 0)
                .count();
        System.out.println("\nОпределение количества четных чисел в потоке данных - " + count);

        List<Integer> newList1 = list.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("\nСортировка по возрастанию, по убыванию");
        System.out.println(newList1);

        List<Integer> newList2 = list.stream()
                .sorted(((o1, o2) -> o2 - o1))
                .collect(Collectors.toList());
        System.out.println("\nВывод минимального и максимального элемента");
        System.out.println(newList2);

        System.out.println("\nОтфильтровать значения, условие -   > 20. Отсортировать их по возрастанию. Вывести значения умножив на 10");
        list.stream()
                .filter(valeu -> valeu > 20)
                .sorted()
                .forEach(value -> System.out.print(value * 10 + " "));

        System.out.println("\n\nПропустить 5 значений листа, задать лимит в 10 значений. Найти уникальные значения и определить среди них максимальное");
        Optional<Integer> maxListUnic = list.stream()
                .skip(5)
                .limit(10)
                .distinct()
                .max(Integer::compare);
        if (maxListUnic.isPresent()) {
            System.out.println(maxListUnic.get());
        }

        System.out.println("\nПропустить 5 значений листа, задать лимит в 10 значений. Каждое число умножить на 10, отсортировать по убыванию, " +
                "вывести значения, прибавив 5");
        list.stream()
                .skip(5)
                .limit(10)
                .map(o1 -> o1 * 10)
                .sorted(((o1, o2) -> o2 - o1))
                .forEach(value -> System.out.print(value + 5 + " "));
    }
}