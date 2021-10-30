package com.lesson2dz;

//3)Вычислить: 1+2+4+8+...+256

public class Home03For {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 256;) {
            sum += i;
            i *= 2;
        }
        System.out.println("Сумма = " + sum);
    }
}
