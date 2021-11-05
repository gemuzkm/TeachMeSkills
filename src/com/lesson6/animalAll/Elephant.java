package com.lesson6.animalAll;

public class Elephant extends Mammals {

    public Elephant(boolean head, boolean eye, int light) {
        super(head, eye, light);
    }

    @Override
    public String toString() {
        return "Elephant " + super.toString();
    }
}
