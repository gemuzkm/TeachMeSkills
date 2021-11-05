package com.lesson6.animalAll;

public class Whale extends Fish {

    public Whale(boolean head, boolean eye, int light) {
        super(head, eye, light);
    }

    @Override
    public void nutrition() {
        System.out.println("Питается планктоном");
    }

    @Override
    public String toString() {
        return "Whale " + super.toString();
    }
}
