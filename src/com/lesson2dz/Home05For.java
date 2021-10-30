package com.lesson2dz;

//5)Напишите программу печати таблицы перевода расстояний из дюймов в
//        сантиметры для значений длин от 1 до 20 дюймов. 1 дюйм = 2,54 см

public class Home05For {
    public static void main(String[] args) {
        for (int i = 1; i <= 20; i++) {
            System.out.println(i + " дюйм = " + i * 2.54 + " см");
        }
    }
}
