package com.lesson3dz;

//5)Создайте 2 массива из 5 случайных целых чисел из отрезка [0;15] каждый,
// выведите массивы на экран в двух отдельных строках. Посчитайте среднее
// арифметическое элементов каждого массива и сообщите, для какого из
//массивов это значение оказалось больше (либо сообщите, что их средние арифметические равны).

import java.util.Random;

public class Home05 {
    public static void main(String[] args) {
        int size = 5;
        Random random = new Random();
        int[] array1 = new int[size];
        int[] array2 = new int[size];

        for (int i = 0; i < size; i++) {
            array1[i] = random.nextInt(15);
            array2[i] = random.nextInt(15);
        }

//        for (int i = 0; i < size; i++) {
//            System.out.print(array1[i] + " ");
//        }
        for (int out : array1) {
            System.out.print(out + " ");
        }
        System.out.println();

//        for (int i = 0; i < size; i++) {
//            System.out.print(array2[i] + " ");
//        }
        for (int out: array2) {
            System.out.print(out + " ");
        }

        int sum1 = 0;
        int sum2 = 0;
        double medium1 = 0;
        double medium2 = 0;

        for (int i = 0; i < size; i++) {
            sum1 += array1[i];
            sum2 += array2[i];
        }

        medium1 = (double) sum1 / size;
        medium2 = (double) sum2 / size;

        if (medium1 > medium2) {
            System.out.println("\nСреднее арифметическое первого больше");
        } else {
            if (medium1 < medium2) {
                System.out.println("\nСреднее арифметическое второго больше");
            } else System.out.println("\nСредние арифметические равны");
        }
    }
}
