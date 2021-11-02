package com.lesson5dz;

//Нужно создать класс Calculator, в нем будет 2 поля для значений
// Сделать конструктор, который позволяет проинициализировать поля
// сделать геттеры и сеттеры для доступа к этим полям
// сделать 4 метода с основными математическими операциями
// использовать private и public

public class Calculator {
    private int a;
    private int b;

    public Calculator(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int sum(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double division(int a, int b) {
        return (double) a / b;
    }
}
