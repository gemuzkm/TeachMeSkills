package com.lesson3dz;

//9) Реализовать сортировку пузырьком

import java.util.Random;

public class Home09 {
    public static void main(String[] args) {
        int size = 30;
        Random random = new Random();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100);
        }

        for (int out: array) {
            System.out.print(out + " ");
        }

        int tmp;
        for (int i = 0; i < size - 1; i++) {
            for (int j = i; j < size; j++) {
                if (array[i] > array[j]) {
                    tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
        System.out.println("\nСортировка по возрастанию");
        for (int out: array) {
            System.out.print(out + " ");
        }
    }
}
