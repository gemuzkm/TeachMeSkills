package com.lesson6.animalAll;

public abstract class Mammals extends Animal implements Actions {


    public Mammals(boolean head, boolean eye, int light) {
        super(head, eye, light);
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
