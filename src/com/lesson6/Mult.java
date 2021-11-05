package com.lesson6;

public class Mult implements Math {
    @Override
    public double action(int a, int b) {
        return (double) a * b;
    }
}
