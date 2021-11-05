package com.lesson6;

public class MainMath {
    public static void main(String[] args) {
        Div div = new Div();
        System.out.println(div.action(5,10));

        Mult mult = new Mult();
        System.out.println(mult.action(10, 30));

        Sum sum = new Sum();
        System.out.println(sum.action(4, 6));

        Subtract subtract = new Subtract();
        System.out.println(subtract.action(10, 5));
    }
}
