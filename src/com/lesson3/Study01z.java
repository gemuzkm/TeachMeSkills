package com.lesson3;

//1) Посчитать количество четных элементов массива
// вывод оформил в строку, для наглядности

import java.util.Random;

public class Study01z {
    public static void main(String[] args) {
        int size = 10;
        int[] array = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100);
            System.out.print(array[i] + " ");
        }

        int cout = 0;
        for (int i = 0; i < size; i++) {
            if (array[i] % 2 == 0) cout++;
        }

        System.out.println("\nКоличество четных эелементов = " + cout);
    }
}
