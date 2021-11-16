package com.lesson9;

import java.util.Arrays;

public class Study01 {
    public static void main(String[] args) {
        String str = "I like Java!!!";
        String str2 = "ava i agga v";

        //-Напишите метод, который принимает в качестве параметра любую строку, например “I like Java!!!”.
        st0(str);

        //-Распечатать последний символ строки. Используем метод String.charAt().
        st1(str);

        //-Проверить, заканчивается ли ваша строка подстрокой “!!!”. Используем метод String.endsWith().
        st2(str);

        //-Проверить, начинается ли ваша строка подстрокой “I like”. Используем метод String.startsWith().
        st3(str);

        //-Проверить, содержит ли ваша строка подстроку “Java”. Используем метод String.contains().
        st4(str);

        //-Найти позицию подстроки “Java” в строке “I like Java!!!”.
        st5(str);

        //-Заменить все символы “а” на “о”.
        st6(str);

        //-Преобразуйте строку к верхнему регистру.
        st7(str);

        //-Преобразуйте строку к нижнему регистру.
        st8(str);

        //-Вырезать строку Java c помощью метода String.substring().
        st9(str);

        //Написать метод, который находит и выводит все слова палиндромы в тексте.
        st10(str2);

        //-Написать метод, который находит и выводит все слова, длина которых от 3 до 5 включительно.
        st11(str2);

        //-Написать метод, который возвращает самое маленькое слово в тексте.
        st12(str2);

        //-Написать метод, который возвращает самое большое слово в тексте.
        st13(str2);

        //-Используя StringBuilder сделайте выражения 3 + 56 = 59 3 – 56 = -53 3 * 56 = 168.
        st14();

        //-Составить программу, которая вычисляет результат данного ребуса, используя StringBuilder и String
        str15("сова", "семь", "ухо", "ели");
    }

    public static void st0(String input) {
        System.out.println("st0- " + input);
    }

    public static void st1(String input) {
        System.out.println("st1- " + input.charAt(input.length() - 1));
    }

    public static void st2(String input) {
        System.out.println("st2- " + input.endsWith("!!!"));
    }

    public static void st3(String input) {
        System.out.println("st3- " + input.startsWith("I like"));
    }

    public static void st4(String input) {
        System.out.println("st4- " + input.contains("Java"));
    }

    public static void st5(String input) {
        System.out.println("st5- " + input.indexOf("Java"));
    }

    public static void st6(String input) {
        System.out.println("st6- " + input.replace("a", "o"));
    }

    public static void st7(String input) {
        System.out.println("st7- " + input.toUpperCase());
    }

    public static void st8(String input) {
        System.out.println("st8- " + input.toLowerCase());
    }

    public static void st9(String input) {
        String searchString = "Java";
        System.out.println("st9- " + input.substring(input.indexOf(searchString), input.indexOf(searchString) + searchString.length()));
    }

    public static void st10(String input) {
        System.out.println("\nst10");
        String[] arr = input.split(" ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].trim().length() == 1) {
                System.out.println(arr[i]);
            } else {
                char[] arrChar = arr[i].trim().toCharArray();
                char[] arrChar2 = new char[arrChar.length];
                int jj = 0;
                for (int j = arrChar.length - 1; j >= 0; j--) {
                    arrChar2[jj] = arrChar[j];
                    jj++;
                }
                if (Arrays.equals(arrChar2, arrChar)) {
                    System.out.println(arr[i]);
                }
            }
        }
    }

    public static void st11(String input) {
        System.out.println("\nst11");
        String[] arr = input.split(" ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() >= 3 && arr[i].length() <= 5) {
                System.out.println(arr[i]);
            }
        }
    }

    public static void st12(String input) {
        System.out.println("\nst12");
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

    public static void st13(String input) {
        System.out.println("\nst13");
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

    public static void st14() {
        System.out.println("\nst14");
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

    public static void str15(String input1, String input2, String input3, String input4) {
        System.out.println("\nst15");
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder i3nput3 = new StringBuilder(input3);
        stringBuilder.append(input1.substring(0, input1.length() - 1));
        stringBuilder.append(input2.substring(0, input1.length() - 1)).append(" ");
        stringBuilder.append(i3nput3.reverse());
        stringBuilder.append(input4.substring(0, input4.length() - 1));
        System.out.println(stringBuilder);
    }
}
