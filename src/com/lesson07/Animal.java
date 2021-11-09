package com.lesson07;

public abstract class Animal {
    private int a = 5;
    private String b = "test";

    public Animal(int a, String b) {
        this.a = a;
        this.b = b;
    }

    abstract void voice();
}
