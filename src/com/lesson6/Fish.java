package com.lesson6;

public class Fish extends Animal implements Actions {
    @Override
    public void moving() {
        System.out.println("Плавает");
    }

    @Override
    public void nutrition() {
        System.out.println("Питается кормом");
    }
}
