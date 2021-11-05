package com.lesson6;

public interface Fly {
    void fly();

    default  void printHelloWorld() {
        System.out.println("Hello");
    }
}
