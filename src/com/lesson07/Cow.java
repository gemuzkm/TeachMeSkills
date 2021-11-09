package com.lesson07;

public class Cow extends Animal{
    public Cow(int a, String b) {
        super(a, b);
    }

    @Override
    void voice() {
        System.out.println("Mu");
    }
}
