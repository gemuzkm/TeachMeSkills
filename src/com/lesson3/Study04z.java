package com.lesson3;

//4) «Сожмите» массив, выбросив из него каждый второй элемент. «Освободившиеся» места массива заполните нулями.
// вывод оформил в строку, для наглядности

import java.util.Random;

public class Study04z {
    public static void main(String[] args) {
        int size = 20;
        int[] array = new int[size];
        Random random = new Random();

        System.out.println("Исходный массив");
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100);
            System.out.print(array[i] + " ");
        }

        for (int i = 0; i < size; i++) {
            if (i % 2 != 0 && i != 0) array[i] = 0;
        }

        System.out.println("\n\"Сжатый\" массив");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }

    }
}
