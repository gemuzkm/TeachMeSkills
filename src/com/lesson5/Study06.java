package com.lesson5;

// передается копия, т.е. не само число

public class Study06 {
    public static void main(String[] args) {
        int a = 5;
        System.out.println(a);
        a(a);
        System.out.println(a);
    }

    static void a(int b) {
        b = 11;
    }
}
