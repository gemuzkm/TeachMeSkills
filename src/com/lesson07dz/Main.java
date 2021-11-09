package com.lesson07dz;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Spaceport spaceport =  new Spaceport();
        spaceport.start(new Shuttle());
        spaceport.start(new SpaceX());

    }
}
