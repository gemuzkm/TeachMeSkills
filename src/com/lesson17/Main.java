package com.lesson17;

public class Main {
    public static void main(String[] args) throws InterruptedException {
//        MyFirstThread myFirstThread = new MyFirstThread();
//        myFirstThread.start();
//        myFirstThread.join();
//
//        MySecondThread mySecondThread = new MySecondThread();
//        Thread thread = new Thread(mySecondThread);
//        thread.start();
//        System.out.println(thread.isAlive());
//        System.out.println("end code");

        A a = new A();
        Manager manager = new Manager();
        MyThirdThread myThirdThread = new MyThirdThread(manager, a ,1);
        MyThirdThread myThirdThread1 = new MyThirdThread(manager, a,2);
        Thread thread = new Thread(myThirdThread);
        Thread thread1 = new Thread(myThirdThread1);
        thread.start();
        thread1.start();

    }
}
