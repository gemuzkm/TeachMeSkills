package com.lesson2dz;

//4)Составьте программу, вычисляющую A*B, не пользуясь операцией
//        умножения.

public class Home04DoWhile {
    public static void main(String[] args) {
        int a = 30;
        int b = 60;
        int AB = 0;
        int i = 0;
        do {
            AB += a;
            i++;
        } while (i < b);
        System.out.println(a + " * " + b + " = " + AB);
    }
}
