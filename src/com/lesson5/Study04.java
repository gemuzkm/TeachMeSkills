package com.lesson5;

import java.util.Arrays;

public class Study04 {
    public static void main(String[] args) {

        int[] array = new int[1];
        array[0] = 5;
        System.out.println(Arrays.toString(array));
        a(array);
        System.out.println(Arrays.toString(array));
    }
    // новый метод, ссылка на на новый участок памяти
    static void a(int[] b) {
        b = new int[] {4};
    }
}

