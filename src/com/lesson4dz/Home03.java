package com.lesson4dz;

//3)Проверить произведение элементов какой диагонали больше.

import java.util.Arrays;
import java.util.Random;

public class Home03 {
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

        int multiplyMainD = 1;
        int multiplySideD = 1;

        for (int i = 0; i < sizeX; i++) {
            multiplyMainD *= array[i][i];
        }

        for (int i = 0; i < sizeX; i++) {
            for (int j = sizeX - i - 1; j >= 0; j--) {
                multiplySideD *= array[i][j];
                break;
            }
        }

        if (multiplyMainD > multiplySideD) {
            System.out.println("Произведение больше в главной");
        } else {
            if (multiplyMainD < multiplySideD) {
                System.out.println("Произведение больше побочной");
            } else  {
                System.out.println("Произведения равны");
            }
        }
    }
}
