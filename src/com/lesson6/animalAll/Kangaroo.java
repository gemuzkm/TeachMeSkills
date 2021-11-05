package com.lesson6.animalAll;

public class Kangaroo extends Mammals {
    private int Ears;

    public Kangaroo(boolean head, boolean eye, int light, int ears) {
        super(head, eye, light);
        Ears = ears;
    }

    @Override
    public void moving() {
        System.out.println("Прыгает");
    }

    @Override
    public String toString() {
        return "Kangaroo " + super.toString() + ", ears=" + Ears;
    }
}
