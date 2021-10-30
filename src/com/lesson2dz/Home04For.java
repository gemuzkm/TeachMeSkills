package com.lesson2dz;

//4)Составьте программу, вычисляющую A*B, не пользуясь операцией
//        умножения.

public class Home04For {
    public static void main(String[] args) {
        int a = 7;
        int b = 6;
        int AB = 0;
        for (int i = 0; i < b; i++) {
            AB += a;
        }
        System.out.println(a + " * " + b + " = " + AB);
    }
}
