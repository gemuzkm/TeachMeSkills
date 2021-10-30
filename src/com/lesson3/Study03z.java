package com.lesson3;

//3) найти среднее арифметическое элементов массива больше 20
// вывод оформил в строку, для наглядности

import java.util.Random;

public class Study03z {
    public static void main(String[] args) {
        int size = 20;
        int[] array = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100);
            System.out.print(array[i] + " ");
        }

        int count = 0;
        int sum = 0;
        for (int i = 0; i < size; i++) {
            if (array[i] > 20) {
                count++;
                sum += array[i];
            }
        }
        System.out.println("\nСреднее арифметическое элементов массива больше 20 = " + (double) sum/count) ;

    }
}
