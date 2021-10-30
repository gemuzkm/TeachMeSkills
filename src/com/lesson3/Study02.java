package com.lesson3;

import java.util.Random;

public class Study02 {
    public static void main(String[] args) {
        int size = 4;
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100);
        }

        for (int i = 0; i < size; i++) {
            System.out.println(array[i]);
        }

    }
}
