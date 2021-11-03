package com.lesson5;

public class User2 {
    private int age;
    String name;
    protected double foot;
    public boolean isBootbal;

    public int getAge() {
        return age;
    }

    public User2() {
    }

    public static class Calculator {
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

    public static class TestCalc {
        public static void main(String[] args) {
            Calculator calculator = new Calculator(4, 5);
            calculator.subtract(calculator.getA(), calculator.getB());
            calculator.division(calculator.getA(), calculator.getB());
            calculator.sum(calculator.getA(), calculator.getB());
            calculator.multiply(calculator.getA(), calculator.getB());
        }
    }
}
