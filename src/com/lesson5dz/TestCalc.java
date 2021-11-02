package com.lesson5dz;

public class TestCalc {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(4, 5);
        calculator.subtract(calculator.getA(), calculator.getB());
        calculator.division(calculator.getA(), calculator.getB());
        calculator.sum(calculator.getA(), calculator.getB());
        calculator.multiply(calculator.getA(), calculator.getB());
    }
}
