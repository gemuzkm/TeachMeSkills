package com.lesson3dz;

// 1)Создайте массив из всех чётных чисел от 0 до 20 и выведите элементы массива на
// экран сначала в строку, отделяя один элемент от другого пробелом, а затем в столбик
// (отделяя один элемент от другого началом новой строки). Перед созданием массива
// подумайте, какого он будет размера.

public class Home01 {
    public static void main(String[] args) {
        //определение количество эллементов в массиве
        int count = 0;
        for (int i = 0; i <= 20; i++) {
            if (i % 2 == 0  && i != 0) count++;
        }
        int[] array = new int[count];
        int index = 0;

        for (int i = 0; i <= 20; i++) {
            if (i % 2 == 0  && i != 0) {
                array[index] = i;
                index++;
            }
        }

        System.out.println("Вывод эементов массива в строку");
//        for (int i = 0; i < count; i++) {
//            System.out.print(array[i] + " ");
//        }
        for (int out: array) {
            System.out.print(out + " ");
        }

       System.out.println("\nВывод элементов массива в столбик");
//        for (int i = 0; i < count; i++) {
//            System.out.println(array[i] + " ");
//        }
        for (int out: array) {
            System.out.println(out);
        }

    }
}
