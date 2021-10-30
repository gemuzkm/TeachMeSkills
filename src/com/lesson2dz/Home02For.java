package com.lesson2dz;
//2)Одноклеточная амеба каждые 3 часа делится на 2 клетки. Определить,
//        сколько амеб будет через 3, 6, 9, 12,..., 24 часа.

public class Home02For {
    public static void main(String[] args) {
        int sum = 1;

        for (int i = 1; i <= 24; i++) {
            if (i % 3 == 0) {
                sum = sum  * 2;
            }
        }
        System.out.println("Количество клеток через 24 часа будет = " + sum);
    }
}
