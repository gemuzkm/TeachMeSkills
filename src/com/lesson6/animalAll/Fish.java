package com.lesson6.animalAll;

public class Fish extends Animal implements Actions {

    public Fish(boolean head, boolean eye, int light) {
        super(head, eye, light);
    }

    @Override
    public void moving() {
        System.out.println("Плавает");
    }

    @Override
    public void nutrition() {
        System.out.println("Питается кормом");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

