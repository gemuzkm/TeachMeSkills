package com.lesson4dz;

//4)Посчитать сумму четных элементов стоящих над побочной диагональю (не  включительно)

import java.util.Random;

public class Home04 {
    public static void main(String[] args) {
        Random random = new Random();
        int[][] array = new int[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                array[i][j] = random.nextInt(50);
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
        int sum = 0;
        int x = 5;
        for (int i = 1; i < 5; i++) {
            x--;
            for (int j = 4; j >= x; j--) {
                if (array[i][j] % 2 == 0 && array[i][j] !=0) {
                    sum += array[i][j];
                    System.out.print(array[i][j] + " ");
                }
            }
        }
        System.out.println("Сумма четных элементов стоящих над побочной диагональю (не  включительно) = " + sum);
    }
}
