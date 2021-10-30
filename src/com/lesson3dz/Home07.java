package com.lesson3dz;

//7)Создайте массив из 12 случайных целых чисел из отрезка [0;15].
// Определите какой элемент является в этом массиве максимальным
// и сообщите индекс его последнего вхождения в массив.

import java.util.Random;

public class Home07 {
    public static void main(String[] args) {
        Random random = new Random();
        int size = 12;
        int[] array = new int[12];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(16);
        }

        int index = 0;
        int max = array[0];

        for (int i = 0; i < size; i++) {
            if (max <= array[i]) {
                max = array[i];
                index = i;
            }
        }

        System.out.println("Максимальный элемент = " + max + ". \nИндекс его последнего вхождения в массив = " + index);
    }
}
