package com.lesson4dz;

//5)Транспонировать матрицу(1 столбец станет 1-й строкой, 2-й столбец - 2-йстрокой и т. д.)

import java.util.Arrays;
import java.util.Random;

public class Home05 {
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

        for (int i = 0; i < sizeX; i++) {
            System.out.println(Arrays.toString(array[i]));
        }

        System.out.println();

        int tmp = 0;

        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j <= i; j++) {
                tmp = array[i][j];
                array[i][j] = array[j][i];
                array[j][i] = tmp;
            }
        }

        for (int i = 0; i < sizeX; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }
}
