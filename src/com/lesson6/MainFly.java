package com.lesson6;

public class MainFly {
    public static void main(String[] args) {
        Dandelion dandelion = new Dandelion();
        dandelion.fly();
        dandelion.printHelloWorld();

        Plane plane = new Plane();
        plane.fly();
        plane.printHelloWorld();
    }
}
