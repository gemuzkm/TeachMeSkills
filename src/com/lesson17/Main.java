package com.lesson17;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MyFirstThread myFirstThread = new MyFirstThread();
        myFirstThread.start();
        myFirstThread.join();
        System.out.println("end code");

    }
}
