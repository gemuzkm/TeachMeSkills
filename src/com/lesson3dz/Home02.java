package com.lesson3dz;

// 2)Создайте массив из всех нечётных чисел от 0 до 99, выведите его на экран в
// строку, а затем этот же массив выведите на экран тоже в строку, но в обратном
// порядке (99 97 95 93 ... 7 5 3 1).


public class Home02 {
    public static void main(String[] args) {
        //определение количества эллементов в массиве
        int count = 0;
        for (int i = 0; i <= 99; i++) {
            if (i % 2 !=0) {
                count++;
            }
        }

        int[] array = new int[count];
        int index = 0;

        for (int i = 0; i <= 99; i++) {
            if (i % 2 !=0) {
                array[index] = i;
                index++;
            }
        }

        System.out.println("Массив из всех нечетных чисел от 0 до 99");
//        for (int i = 0; i < count; i++) {
//            System.out.print(array[i] + " ");
//        }
        for (int out: array) {
            System.out.print(out + " ");
        }

        System.out.println("\nМассив из всех нечетных чисел от 0 до 99 (реверс)");
        for (int i = count - 1 ; i >= 0 ; i--) {
            System.out.print(array[i] + " ");
        }
    }
}
