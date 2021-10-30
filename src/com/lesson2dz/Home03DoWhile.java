package com.lesson2dz;

//3)Вычислить: 1+2+4+8+...+256

public class Home03DoWhile {
    public static void main(String[] args) {
        int sum = 0;
        int i = 1;

        do {
            sum += i;
            i *= 2;
        } while (i <=256);
        System.out.println("Сумма = " + sum);
    }
}
