package com.lesson6.animalAll;

public abstract class Mammals extends Animal implements Actions {
    public Mammals(String head, String eye, int age) {
        super(head, eye, age);
    }

    @Override
    public void moving() {
        System.out.println("Ходит");
    }

    @Override
    public void nutrition() {
        System.out.println("Питается травой");
    }
}
