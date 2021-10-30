package com.lesson3dz;

//8)Создайте два массива из 10 целых случайных чисел из отрезка [0;9]
// и третий массив из 10 действительных чисел. Каждый элемент с i-ым
// индексом третьего массива должен равняться отношению элемента из
// первого массива с i-ым индексом к элементу из второго массива с
// i-ым индексом. Вывести все три массива на экран (каждый на отдельной
// строке), затем вывести количество целых элементов в третьем массиве.

import java.util.Random;

public class Home08 {
    public static void main(String[] args) {
        int size = 10;
        Random random = new Random();
        int[] array1 = new int[size];
        int[] array2 = new int[size];
        double[] array3 = new double[size];

        for (int i = 0; i < size; i++) {
            array1[i] = random.nextInt(10);
            array2[i] = random.nextInt(10);
        }

        System.out.println("Первый массив");
        for (int out : array1) {
            System.out.print(out + " ");
        }
        System.out.println("\nВторой массив");
        for (int out: array2) {
            System.out.print(out + " ");
        }
        System.out.println("\nТретий массив");
        for (int i = 0; i < size; i++) {
            array3[i] = (double) array1[i] / array2[i];
        }

        for (double out : array3) {
            System.out.print(out +  " ");
        }

        int count = 0;
        for (int i = 0; i < size; i++) {
            if (array3[i] % 1 == 0) count++;
        }
        System.out.println("\nКоличество целых элементов в третьем массиве = " + count );
    }
}
