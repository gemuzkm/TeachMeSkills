package com.lesson6;

public class WirePhone extends Phone {

    @Override
    public void call() {
        super.call();
        System.out.println("Звоним по проводам");
    }
}
