package com.lesson3;

//6) Найти наименьший элемент среди элементов с четными индексами массива
// вывод оформил в строку, для наглядности

import java.util.Random;

public class Study06z {
    public static void main(String[] args) {
        int size = 20;
        Random random = new Random();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100);
            System.out.print(array[i] + " ");
        }

        int min = array[2];
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0 && i !=0) {
                if (min > array[i]) min = array[i];
            }
        }
        System.out.println("\nНаименьший элемент среди элементов с четными индексами массива = " + min);
    }
}
