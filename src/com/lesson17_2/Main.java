package com.lesson17_2;

public class Main {
    public static void main(String[] args) {

        Manager manager = new Manager();
        MyThread myThread = new MyThread(manager, 22);
        MyThread myThread1 = new MyThread(manager, 55);

        Thread thread = new Thread(myThread);
        Thread thread1 = new Thread(myThread1);

        thread.start();
        thread1.start();
    }
}
