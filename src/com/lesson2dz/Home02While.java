package com.lesson2dz;

//2)Одноклеточная амеба каждые 3 часа делится на 2 клетки. Определить,
//        сколько амеб будет через 3, 6, 9, 12,..., 24 часа.

public class Home02While {
    public static void main(String[] args) {
        int sum = 1;
        int i = 1;
        while (i <= 24) {
            if (i % 3 == 0) {
                sum = sum  * 2;
            }
            i++;
        }
        System.out.println("Количество клеток через 24 часа будет = " + sum);
    }
}
