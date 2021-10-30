package com.lesson2dz;

//3)Вычислить: 1+2+4+8+...+256

public class Home03While {
    public static void main(String[] args) {
        int sum = 0;
        int a = 1;

        while (a <= 256) {
            sum = sum + a;
            a = a * 2;
        }
        System.out.println("Сумма = " + sum);
    }
}
