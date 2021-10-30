package com.lesson4;

import java.util.Random;

public class Study02 {
    public static void main(String[] args) {
        int[][] array = new int[4][4];
        Random random = new Random();

        for (int i = 0; i < 4; i++) {
            for (int j=0; j < 4; j++) {
                array[i][j] = random.nextInt(50);
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        for (int i = 0; i < 4; i++) {
            System.out.print(array[i][i] + " ");
        }

    }
}
