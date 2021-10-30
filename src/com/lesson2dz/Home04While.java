package com.lesson2dz;

//4)Составьте программу, вычисляющую A*B, не пользуясь операцией
//        умножения.

public class Home04While {
    public static void main(String[] args) {
        int a = 3;
        int b = 6;
        int AB = 0;
        int i = 0;
        while (i < b) {
            AB += a;
            i++;
        }
        System.out.println(a + " * " + b + " = " + AB);
    }
}
