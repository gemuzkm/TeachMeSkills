package com.lesson6;

public class Mammals extends Animal implements Actions {
    @Override
    public void moving() {
        System.out.println("Ходит");
    }

    @Override
    public void nutrition() {
        System.out.println("Питается травой");
    }
}
