package com.lesson5;

public class Study02 {
    public static void main(String[] args) {
        System.out.println(method1(3, 18 , 14));
        method2(3,18,14);
    }

    static int method1 (int a, int b, int c) {
        return a + b * c;
    }

    static void method2 (int a, int b, int c) {
        System.out.println(a + b * c);
    }

}
