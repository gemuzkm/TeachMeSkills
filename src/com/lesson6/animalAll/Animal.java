package com.lesson6.animalAll;

public class Animal  {
    private boolean head;
    private boolean eye;
    private int light;

    public Animal(boolean head, boolean eye, int light) {
        this.head = head;
        this.eye = eye;
        this.light = light;
    }

    @Override
    public String toString() {
        return  "head=" + head + ", eye=" + eye + ", light=" + light;
    }
}
