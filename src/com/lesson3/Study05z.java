package com.lesson3;

//5) Проверить различны ли массивы

import java.util.Random;

public class Study05z {
    public static void main(String[] args) {
        int size = 20;
        int inputRandom = 0;

        Random random = new Random();
        int[] array1 = new int[size];
        int[] array2 = new int[size];

        for (int i = 0; i < size; i++) {
//      Проверка, когда массивы вероятно не равны
//           array1[i] = random.nextInt(100);
//           array2[i] = random.nextInt(100);
//
//      Првоерка, когда массивы равны
            inputRandom = random.nextInt(100);
            array1[i] = inputRandom;
            array2[i] = inputRandom;
        }

        if (array1.length != array2.length) {
            System.out.println("Массивы не равны");
        } else {
            for (int i = 0; i < size; i++) {
                if (array1[i] != array2[i]) {
                    System.out.println("Массивы не равны");
                    break;
                } else {
                    if (i == size - 1) System.out.println("Массивы равны");
                }

            }
        }
    }
}
