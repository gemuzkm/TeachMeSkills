package com.lesson3;

//7) Найти максимальный элемент в массиве и поменять его местами с нулевым элементом
// вывод оформил в строку, для наглядности

import java.util.Random;

public class Study07z {
    public static void main(String[] args) {
        int size = 20;
        Random random = new Random();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100);
            System.out.print(array[i] + " ");
        }

        int max = array[0];
        int maxInd = 0;
        for (int i = 0; i < size; i++) {
            if (max < array[i]) {
                max = array[i];
                maxInd = i;
            }
        }

        int tmp = array[0];
        array[0] = max;
        array[maxInd] = tmp;

        System.out.println("\nМаксимальный элемент массива = " + max);
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
