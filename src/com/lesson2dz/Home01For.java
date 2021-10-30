package com.lesson2dz;

//)Начав тренировки, спортсмен в первый день пробежал 10 км. Каждый
//        день он увеличивал дневную норму на 10% нормы предыдущего дня. Какой
//        суммарный путь пробежит спортсмен за 7 дней?

public class Home01For {
    public static void main(String[] args) {
        double a = 10;
        double sum = 10;

        for (int i = 0; i < 6; i++) {
            a =  a + 0.1 * a;
            sum += a;
        }
        System.out.println("Суммарный путь за 7 дней = " + sum + " км");
    }
}
