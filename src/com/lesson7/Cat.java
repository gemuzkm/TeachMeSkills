package com.lesson7;

public class Cat extends Animal {

    public Cat(int a, String b) {
        super(a, b);
    }

    @Override
    void voice() {
        System.out.println("Meow");
    }
}
