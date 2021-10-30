package com.lesson4dz;

//2)Вывести нечетные элементы находящиеся под главной
//        диагональю(включительно).

import java.util.Arrays;
import java.util.Random;

public class Home02 {
    public static void main(String[] args) {
        Random random = new Random();
        int sizeX = 5;
        int sizeY = 5;
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
        for (int i = 0; i < sizeX; i++) {
            System.out.println(Arrays.toString(array[i]));
        }

        System.out.println();

        int sum = 0;

        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j <= i; j++) {
                if (array[i][j] % 2 != 0 && array[i][j] !=0) {
                    System.out.print(array[i][j] + " ");
                }
            }
        }
    }
}
