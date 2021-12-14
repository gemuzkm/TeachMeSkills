package com.lesson17_2;

public class Manager {
    public synchronized void printString(String str, int cont) {
        for (int i = 0; i < cont; i++) {
            System.out.print(str);
        }
    }
}
