package com.lesson3dz;

//4)Создайте массив из 20 случайных целых чисел из отрезка [0;20].
// Выведите массив на экран в строку. Замените каждый элемент с нечётным
// индексом на ноль. Снова выведете массив на экран на отдельной строке.

import java.util.Random;

public class Home04 {
    public static void main(String[] args) {
        Random random = new Random();
        int size = 20;
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(21);
        }

        System.out.println("Исходный массив");
//        for (int i = 0; i < size; i++) {
//            System.out.print(array[i] + " ");
//        }
        for (int out: array) {
            System.out.print(out + " ");
        }

        for (int i = 0; i < size; i++) {
            if (i % 2 !=0) array[i] = 0;
        }

        System.out.println("\nИзмененный массив");
//        for (int i = 0; i < size; i++) {
//            System.out.print(array[i] + " ");
//        }
        for (int out: array) {
            System.out.print(out + " ");
        }
    }
}
