package com.lesson13;

public class Study3 {
    public static void main(String[] args) {
        MyInterface myInterface = (q, w) -> q + w;
        System.out.println(myInterface.action(10,15));

        MyInterface myInterface1 = new MyInterface() {
            @Override
            public int action(int a, int b) {
                return a + b;
            }
        };

        MyInterface myInterface2 = Integer::compare;
        System.out.println(myInterface2.action(5, 6));


    }
}
