package com.lesson2dz;

//6)Напишите программу вывода всех четных чисел от 2 до 100
//        включительно

public class Home06DoWhile {
    public static void main(String[] args) {
        int i = 2;
        do {
            if (i % 2 == 0) System.out.println(i);
            i++;
        } while (i <= 100);
    }
}
