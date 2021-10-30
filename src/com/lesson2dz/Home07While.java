package com.lesson2dz;

//7)Напишите программу, определяющую сумму всех нечетных чисел от 1
//        до 99

public class Home07While {
    public static void main(String[] args) {
        int sum = 0;
        int i = 1;
        while (i < 100) {
            if (i % 2 !=0) sum +=i;
            i++;
        }

        System.out.println("Сумма все нечетных чисел от 1 до 99 = " + sum);
    }
}
