package com.lesson6.animalAll;

public class Dolphin extends Fish {
    private int tail;

    public Dolphin(boolean head, boolean eye, int light, int tail) {
        super(head, eye, light);
        this.tail = tail;
    }


    @Override
    public void nutrition() {
        System.out.println("Питается рыбой");
    }

    @Override
    public String toString() {
        return "Dolphin " + super.toString() + " , tail=" + tail;
    }
}
