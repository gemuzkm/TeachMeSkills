package com.lesson3;

//2 ) посчитать сумму нечетных элементов
// вывод оформил в строку, для наглядности

import java.util.Random;

public class Study02z {
    public static void main(String[] args) {
        int size = 20;
        int[] array = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100);
            System.out.print(array[i] + " ");
        }

        int sum = 0;
        for (int i = 0; i < size; i++) {
            if (array[i] % 2 !=0 && array[i] !=0) sum += array[i];
        }

        System.out.println("\nСумма нечетных эдементов = " + sum);
    }
}
