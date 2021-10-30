package com.lesson2dz;

//7)Напишите программу, определяющую сумму всех нечетных чисел от 1
//        до 99

public class Home07DoWhile {
    public static void main(String[] args) {
        int sum = 0;
        int i = 1;
        do {
            if (i % 2 !=0) sum +=i;
            i++;
        }  while (i < 100);

        System.out.println("Сумма все нечетных чисел от 1 до 99 = " + sum);
    }
}
