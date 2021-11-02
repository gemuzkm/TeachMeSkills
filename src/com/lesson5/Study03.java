package com.lesson5;

import java.util.Arrays;

public class Study03 {
    public static void main(String[] args) {

        // передача по ссылке, пример

        int[] array = new int[1];
        array[0] = 5;
        System.out.println(Arrays.toString(array));
        a(array);
        System.out.println(Arrays.toString(array));
     }

     static void a(int[] array) {
        array[0] = 1;
     }
}
