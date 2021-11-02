package com.lesson5;

public class HelloWorld {
    public static void main(String[] args) {
        User andrei = new User(21, "Andrei");
        System.out.println(andrei.getAge());
        User andrei1 = new User(22, "Andrei");
        System.out.println(andrei1.getAge());
        User andrei2 = new User(23, "Andrei");
        System.out.println(andrei2.getAge());
        User andrei3 = new User(24, "Andrei");
        System.out.println(andrei3.getAge());
        User andrei4 = new User(25, "Andrei");
        System.out.println(andrei4.getAge());
    }
}
