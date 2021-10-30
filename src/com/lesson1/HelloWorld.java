package com.lesson1;

public class HelloWorld {
    public static void main(String[] args) {
        int a1 = (7 + 5) * 12;
        System.out.println(a1);

        double a2 = (double) (100 + 1122) * 3 / 15;
        System.out.println(a2);

        double a3 = (double) (111 + 222) * 15 / 17 + (double) (333 + 444) / 29;
        System.out.println(a3);

        int a = 8;
        int b = a++;
        System.out.println(a);  // 9
        System.out.println(b);  // 8

    }
}
