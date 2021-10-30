package com.lesson2dz;

//2)Одноклеточная амеба каждые 3 часа делится на 2 клетки. Определить,
//        сколько амеб будет через 3, 6, 9, 12,..., 24 часа.

public class Home02DoWhile {
    public static void main(String[] args) {
        int sum = 1;
        int i = 1;
        do {
            if (i % 3 == 0) {
                sum = sum  * 2;
            }
            i++;
        } while (i <= 24);
        System.out.println("Количество клеток через 24 часа будет = " + sum);
    }
}
