package com.lesson9;

/*
-Напишите метод, который принимает в качестве параметра любую строку, например “I like Java!!!”.
-Распечатать последний символ строки. Используем метод String.charAt().
-Проверить, заканчивается ли ваша строка подстрокой “!!!”. Используем метод String.endsWith().
-Проверить, начинается ли ваша строка подстрокой “I like”. Используем метод String.startsWith().
-Проверить, содержит ли ваша строка подстроку “Java”. Используем метод String.contains().
-Найти позицию подстроки “Java” в строке “I like Java!!!”.
-Заменить все символы “а” на “о”.
-Преобразуйте строку к верхнему регистру.
-Преобразуйте строку к нижнему регистру.
-Вырезать строку Java c помощью метода String.substring().
----
-Написать метод, который находит и выводит все слова палиндромы в тексте.
-Написать метод, который находит и выводит все слова, длина которых от 3 до 5 включительно.
-Написать метод, который возвращает самое маленькое слово в тексте.
-Написать метод, который возвращает самое большое слово в тексте.

-Используя StringBuilder сделайте выражения 3 + 56 = 59 3 – 56 = -53 3 * 56 = 168.

Составить программу, которая вычисляет результат данного ребуса, используя StringBuilder и String

 */

import java.util.Locale;

public class Study01 {
    public static void main(String[] args) {
        String str = "I like Java!!!";
        String str2 = "ava i agga v";

        st1(str);
        st2(str);
        st3(str);
        st4(str);
        st5(str);
        st6(str);
        st7(str);
        st8(str);
        st9(str);

        st10(str2);
        st11(str2);
        st12(str2);
        st13(str2);

        str14();

        str15("сова", "семь", "ухо", "ели");
    }

    public static void st1 (String input) {
        int strLength = input.length();
        System.out.println(input.charAt(strLength - 1));
    }

    public static void st2 (String  input ) {
        System.out.println(input.endsWith("!!!"));
    }

    public static void st3 (String  input ) {
        System.out.println(input.startsWith("I like"));
    }

    public static void st4 (String  input ) {
        System.out.println(input.contains("Java"));
    }

    public static void st5 (String  input ) {
        System.out.println(input.indexOf("Java"));
    }

    public static void st6 (String  input ) {
        System.out.println(input.replace("a", "o"));
    }

    public static void st7 (String  input) {
        System.out.println(input.toUpperCase(Locale.ROOT));
    }

    public static void st8 (String  input) {
        System.out.println(input.toLowerCase());
    }

    public static void st9 (String  input) {
        System.out.println(input.substring(7,11));
    }

    public static void st10 (String  input) {
        String[] arr  = input.split(" ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() == 1) {
                System.out.println(arr[i]);
            } else
            {
                char [] arrChar = arr[i].toCharArray();
                char [] arrChar2 = new char[arrChar.length];
                int jj = 0;
                for (int j = arrChar.length - 1; j >= 0; j--) {
                    arrChar2[jj] = arrChar[j];
                }
                if (arrChar2.equals(arrChar)) {
                    System.out.println(arr[i]);
                }
            }
        }
    }

    public static void st11 (String  input) {
        String [] arr = input.split(" ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() >= 3 && arr[i].length() <= 5){
                System.out.println(arr[i]);
            }
        }
    }

    public static void st12 (String  input) {

        String[] arr = input.split(" ");
        int min = arr[0].length();
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i].length()) {
                min = arr[i].length();
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (min == arr[i].length()) {
                System.out.println(arr[i]);
                break;
            }
        }
    }

    public static void st13 (String  input) {

        int max = 0;
        String[] arr = input.split(" ");

        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i].length()) {
                max = arr[i].length();
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (max == arr[i].length()) {
                System.out.println(arr[i]);
                break;
            }
        }
    }

    public static void str14 () {
        //3 + 56 = 59      3 – 56 = -53        3 * 56 = 168
        StringBuilder stringBuilder1 = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        StringBuilder stringBuilder3 = new StringBuilder();

        stringBuilder1.append("3").append(" + ").append("56").append(" = ").append("59");
        stringBuilder2.append("3").append(" - ").append("56").append(" = ").append("-53");
        stringBuilder3.append("3").append(" * ").append("56").append(" = ").append("168");

        System.out.println(stringBuilder1);
        System.out.println(stringBuilder2);
        System.out.println(stringBuilder3);
    }

    public static void str15 (String input1, String input2, String input3, String input4) {
        StringBuilder stringBuilder = new StringBuilder();

        StringBuilder i3nput3 = new StringBuilder(input3);
        stringBuilder.append(input1.substring(0,input1.length() - 1));
        stringBuilder.append(input2.substring(0,input1.length() - 1)).append(" ");
        stringBuilder.append(i3nput3.reverse());
        stringBuilder.append(input4.substring(0, input4.length() - 1));

        System.out.println(stringBuilder);
    }
}
