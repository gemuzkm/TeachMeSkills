package com.lesson3dz;

// 3)Создайте массив из 15 случайных целых чисел из отрезка [0; 99].
// Выведите массив на экран. Подсчитайте сколько в массиве чётных элементов
// и выведете это количество на экран на отдельной строке.

import java.util.Random;

public class Home03 {
    public static void main(String[] args) {
        int size = 15;
        Random random = new Random();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100);
        }

//        for (int i = 0; i < size; i++) {
//            System.out.print(array[i] + " ");
//        }
        for (int out: array) {
            System.out.print(out + " ");
        }

        int count = 0;
//        for (int i = 0; i < size; i++) {
//            if (array[i] % 2 == 0 && array[i] != 0) count++;
//        }
        for (int out: array)
        {
            if (out % 2 == 0 && out != 0) count++;
        }
        System.out.println("\nВ массиве чётных элементов = " + count);
    }
}
