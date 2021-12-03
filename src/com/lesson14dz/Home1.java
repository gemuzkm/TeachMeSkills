package com.lesson14dz;

/*
Сделать список целых чисел, заполнить рандомными значениями.



4)
5) Пропустить 5 значений листа, задать лимит в 10 значений. Найти уникальные значения и определить среди них максимальное
6) Пропустить 5 значений листа, задать лимит в 10 значений. Каждое число умножить на 10, отсортировать по убыванию,
вывести значения, прибавив 5
7) Обновить приложение Shop. Все возможные места поиска элементов, фильтрации и тд переделать со stream api
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Home1 {
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            list.add(random.nextInt(100));
        }

        System.out.println(list);
        //1) Определение количества четных чисел в потоке данных

        long count = list.stream()
                .filter(value -> value % 2 == 0)
                .count();
        System.out.println("\nОпределение количества четных чисел в потоке данных - "  + count);

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

        List<Integer> newList3 = list.stream()
                                .collect(Collectors.toList());
        System.out.println("\nОтфильтровать значения, условие -   > 20. Отсортировать их по возрастанию. Вывести значения умножив на 10");
        System.out.println(newList3);


    }
}
