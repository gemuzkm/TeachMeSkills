package com.project.Calculator;

import java.io.IOException;

public class CalculatorOperations {
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
//                                System.out.println("Integer");
                        } else {
                                if (InputData.isNumericDouble(inputUser)) {
                                        isString = false;
                                        isDouble = true;
                                        aDouble = Double.parseDouble(inputUser);
//                                        System.out.println("double");
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
                                bDouble = Double.parseDouble(inputUser);
//                                System.out.println("Integer");
                        } else {
                                if (InputData.isNumericDouble(inputUser)) {
                                        isString = false;
                                        isDouble = true;
                                        bDouble = Double.parseDouble(inputUser);
//                                        System.out.println("double");
                                }
                        }

                        if (isString) {
                                System.out.println("Ввведи число B");
                                inputUser = InputData.readerData();
                        }
                }
        }

        private static void resultOperation(String inputOperation) {
                if (inputOperation.trim().equals("+")) {
                        double doubleSum = aDouble + bDouble;
                        if (!isDouble) {
                                int intSum = (int) (doubleSum / 1);
                                Store.addHistory(String.valueOf(intSum));
                                System.out.println(intSum + "\n");
                        } else {
                                Store.addHistory(String.valueOf(doubleSum));
                                System.out.println(doubleSum + "\n");
                        }
                }

                if (inputOperation.trim().equals("-")) {
                        double doubleDiff = aDouble - bDouble;
                        if (!isDouble) {
                                int intDiv = (int) (doubleDiff / 1);
                                Store.addHistory(String.valueOf(intDiv));
                                System.out.println(intDiv + "\n");
                        } else {
                                Store.addHistory(String.valueOf(doubleDiff));
                                System.out.println(doubleDiff + "\n");
                        }
                }

                if (inputOperation.trim().equals("*")) {
                        double doubleMmultiply = aDouble * bDouble;
                        if (!isDouble) {
                                int intMmultiply = (int) (doubleMmultiply / 1);
                                Store.addHistory(String.valueOf(intMmultiply));
                                System.out.println(intMmultiply + "\n");
                        } else {
                                Store.addHistory(String.valueOf(doubleMmultiply));
                                System.out.println(doubleMmultiply + "\n");
                        }
                }

                if (inputOperation.trim().equals("/")) {
                        if (bDouble == 0.0) {
                                System.out.println("\nДеление на 0 невозможно\n");
                                Store.addHistory("NaN");
                        } else {
                                double doubleMultiply = aDouble / bDouble;
                                if (!isDouble) {
                                        int intMmultiply = (int) (doubleMultiply / 1);
                                        Store.addHistory(String.valueOf(intMmultiply));
                                        System.out.println(intMmultiply + "\n");
                                } else {
                                        Store.addHistory(String.valueOf(doubleMultiply));
                                        System.out.println(doubleMultiply + "\n");
                                }
                        }
                }
        }

        private static void actionOperation () throws IOException {
                System.out.println("Введи нужную опперацию \"*\" - умножить, \"/\" - деление, \"+\" - сумма, \"-\" - разность");
                inputUser = InputData.readerData();
                switch (inputUser) {
                        case "*":
                                resultOperation(inputUser); break;
                        case "/":
                                resultOperation(inputUser); break;
                        case "-":
                                resultOperation(inputUser); break;
                        case "+":
                                resultOperation(inputUser); break;
                        default:
                                System.out.println("Данная операция не поддерживается\n");
                }
        }

}
