package com.lesson2dz;

//6)Напишите программу вывода всех четных чисел от 2 до 100
//        включительно

public class Home06While {
    public static void main(String[] args) {
        int i = 2;
        while (i <= 100) {
            if (i % 2 == 0) System.out.println(i);
            i++;
        }

    }
}
