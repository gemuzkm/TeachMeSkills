package com.lesson4dz;

//1) Почитать сумму четных элементов стоящих на главной диагонали.

import java.util.Arrays;
import java.util.Random;

public class Home01 {
    public static void main(String[] args) {
        Random random = new Random();
        int sizeY = 5;
        int sizeX = 5;
        int[][] array = new int[sizeY][sizeX];

        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                array[i][j] = random.nextInt(50);
            }
        }

//        for (int i = 0; i < sizeY; i++) {
//            for (int j = 0; j < sizeX; j++) {
//                System.out.print(array[i][j] + " ");
//            }
//            System.out.println();
//        }
//
//        System.out.println();

        for (int i = 0; i < sizeX; i++) {
            System.out.println(Arrays.toString(array[i]));
        }

        int sum = 0;

        for (int i = 0; i < sizeY; i++) {
            if (array[i][i] % 2 ==0 && array[i][i] !=0) sum += array[i][i];
        }

        System.out.println("Сумма четных элементов стоящих на главной диагонали = " + sum);
    }
}
