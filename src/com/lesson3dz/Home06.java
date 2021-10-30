package com.lesson3dz;

//6)Создайте массив из 4 случайных целых чисел из отрезка [0;10],
// выведите его на экран в строку. Определить и вывести на экран
// сообщение о том, является ли массив строго возрастающей последовательностью.

import java.util.Random;

public class Home06 {
    public static void main(String[] args) {
        Random random = new Random();
        int size = 4;
// комментить для тестирвоани - начало
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(11);
        }
// комментить для тестирования - конец

//     Часть для тестирования работы
//     int[] array = {11,4,6,10};

//      for (int i = 0; i < size; i++) {
//            System.out.print(array[i] + " ");
//        }
        for (int out: array) {
            System.out.print(out + " ");
        }

        for (int i = 0; i < size - 1; i++) {
            if (array[i] > array[i + 1] ) {
                System.out.println("\nМассив не строго возрастающей последовательности");
                break;
            } else if (i == size - 2) {
                if (array[i] <= array[i + 1]) System.out.println("\nМассив строго возрастающей последовательности");
            }
        }
    }
}
