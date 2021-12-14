package com.lesson17_2;

public class MyThread implements Runnable {
    private  Manager manager;
    private int count;

    public MyThread(Manager manager, int count) {
        this.manager = manager;
        this.count = count;
    }

    @Override
    public void run() {
        manager.printString(String.valueOf(count), count);
    }
}
