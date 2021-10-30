package com.lesson2dz;

//7)Напишите программу, определяющую сумму всех нечетных чисел от 1
//        до 99

public class Home07For {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i < 100; i++) {
            if (i % 2 !=0) sum +=i;
        }
        System.out.println("Сумма все нечетных чисел от 1 до 99 = " + sum);
    }
}
