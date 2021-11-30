package com.lesson13;

//ламбда

public class Study2 {
    public static void main(String[] args) {
        MyInterface myInterface = (q, w) -> {
           int a = 5;
            for (int i = 0; i < 5; i++) {
                System.out.println("sout - " +i);
            }
            return   q + w;
        };
        MyInterface myInterface1 = (q, w) -> q - w;
        System.out.println(myInterface.action(5, 6));
        System.out.println(myInterface1.action(5, 3));
    }
}
