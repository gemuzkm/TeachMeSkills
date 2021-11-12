package com.project;

import java.io.IOException;

public class Calculator {
        private static boolean isDouble;
        private static double aDouble;
        private static double bDouble;
        private static String inputUser;

        public static void actions () throws IOException {
                actionA();
                actionB();
                actionOperation();
        }

        private static void actionA () throws IOException {
                System.out.println("Введи число А");
                inputUser = InputData.readerData();

                boolean isString = true;

                while (isString) {

                        if (InputData.isNumericInteger(inputUser)) {
                                isString = false;
                                aDouble = Double.parseDouble(inputUser);
                                System.out.println("Integer");
                        } else {
                                if (InputData.isNumericDouble(inputUser)) {
                                        isString = false;
                                        isDouble = true;
                                        aDouble = Double.parseDouble(inputUser);
                                        System.out.println("double");
                                }
                        }

                        if (isString) {
                                System.out.println("Ввведи число А");
                                inputUser = InputData.readerData();
                        }
                }
        }

        private static void actionB () throws IOException {
                System.out.println("Введи число B");
                inputUser = InputData.readerData();

                boolean isString = true;

                while (isString) {

                        if (InputData.isNumericInteger(inputUser)) {
                                isString = false;
                                aDouble = Double.parseDouble(inputUser);
                                System.out.println("Integer");
                        } else {
                                if (InputData.isNumericDouble(inputUser)) {
                                        isString = false;
                                        isDouble = true;
                                        aDouble = Double.parseDouble(inputUser);
                                        System.out.println("double");
                                }
                        }


                        if (isString) {
                                System.out.println("Ввведи число B");
                                inputUser = InputData.readerData();
                        }
                }
        }

        private static void actionOperation () throws IOException {
                System.out.println("Введи нужную опперацию \"*\" - умножить, \"/\" - деление, \"+\" - сумма, \"-\" - разность");
                inputUser = InputData.readerData();
                switch (inputUser) {
                        case "*":
                                System.out.println("*"); break;
                        case "/":
                                System.out.println("/"); break;
                        case "-":
                                System.out.println("-"); break;
                        case "+":
                                System.out.println("+"); break;
                        default:
                                System.out.println("Данная операция не поддерживается\n");
                }

        }
}
