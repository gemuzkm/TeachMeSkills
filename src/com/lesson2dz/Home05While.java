package com.lesson2dz;

//5)Напишите программу печати таблицы перевода расстояний из дюймов в
//        сантиметры для значений длин от 1 до 20 дюймов. 1 дюйм = 2,54 см

public class Home05While {
    public static void main(String[] args) {
        int a = 1;

        while (a <= 20) {
            System.out.println(a + " дюйм = " + a * 2.54 + " см");
            a++;
        }
    }
}
