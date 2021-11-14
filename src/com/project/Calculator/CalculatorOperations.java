package com.project.Calculator;

import java.io.IOException;

public class CalculatorOperations {
        private static boolean isDouble;
        private static double aDouble;
        private static double bDouble;
        private static String inputUser;

        private Store store = new Store();
        private InputData inputData = new InputData();

        public void actions () throws IOException {
               new CalculatorOperations().actionA();
               new CalculatorOperations().actionB();
               new CalculatorOperations().actionOperation();
        }

        private void actionA () throws IOException {
                System.out.println("Введи число А");
                inputUser = inputData.readerDataString();

                boolean isString = true;

                while (isString) {

                        if (inputData.isNumericInteger(inputUser)) {
                                isString = false;
                                aDouble = Double.parseDouble(inputUser);
                        } else {
                                if (inputData.isNumericDouble(inputUser)) {
                                        isString = false;
                                        isDouble = true;
                                        aDouble = Double.parseDouble(inputUser);
                                }
                        }

                        if (isString) {
                                System.out.println("Ввведи число А");
                                inputUser = inputData.readerDataString();
                        }
                }
        }

        private void actionB () throws IOException {
                System.out.println("Введи число B");
                inputUser = inputData.readerDataString();

                boolean isString = true;

                while (isString) {

                        if (inputData.isNumericInteger(inputUser)) {
                                isString = false;
                                bDouble = Double.parseDouble(inputUser);
                        } else {
                                if (inputData.isNumericDouble(inputUser)) {
                                        isString = false;
                                        isDouble = true;
                                        bDouble = Double.parseDouble(inputUser);
                                }
                        }

                        if (isString) {
                                System.out.println("Ввведи число B");
                                inputUser = inputData.readerDataString();
                        }
                }
        }

        private void resultOperation(String inputOperation) {
                if (inputOperation.trim().equals("+")) {
                        double doubleSum = aDouble + bDouble;
                        if (!isDouble) {
                                int intSum = (int) (doubleSum / 1);
                                store.addHistory(String.valueOf(intSum));
                                System.out.println("Результат опперации: " + intSum + "\n");
                        } else {
                                store.addHistory(String.valueOf(doubleSum));
                                System.out.println("Результат опперации: " + doubleSum + "\n");
                        }
                }

                if (inputOperation.trim().equals("-")) {
                        double doubleDiff = aDouble - bDouble;
                        if (!isDouble) {
                                int intDiv = (int) (doubleDiff / 1);
                                store.addHistory(String.valueOf(intDiv));
                                System.out.println("Результат опперации: " + intDiv + "\n");
                        } else {
                                store.addHistory(String.valueOf(doubleDiff));
                                System.out.println("Результат опперации: " + doubleDiff + "\n");
                        }
                }

                if (inputOperation.trim().equals("*")) {
                        double doubleMmultiply = aDouble * bDouble;
                        if (!isDouble) {
                                int intMmultiply = (int) (doubleMmultiply / 1);
                                store.addHistory(String.valueOf(intMmultiply));
                                System.out.println("Результат опперации: " + intMmultiply + "\n");
                        } else {
                                store.addHistory(String.valueOf(doubleMmultiply));
                                System.out.println("Результат опперации: " + doubleMmultiply + "\n");
                        }
                }

                if (inputOperation.trim().equals("/")) {
                        if (bDouble == 0.0) {
                                System.out.println("\nДеление на 0 невозможно\n");
                                store.addHistory("NaN");
                        } else {
                                double doubleMultiply = aDouble / bDouble;
                                if (!isDouble) {
                                        int intMmultiply = (int) (doubleMultiply / 1);
                                        store.addHistory(String.valueOf(intMmultiply));
                                        System.out.println("Результат опперации: " + intMmultiply + "\n");
                                } else {
                                        store.addHistory(String.valueOf(doubleMultiply));
                                        System.out.println("Результат опперации: " + doubleMultiply + "\n");
                                }
                        }
                }
        }

        private void actionOperation () throws IOException {
                System.out.println("Введи нужную опперацию \"*\" - умножить, \"/\" - деление, \"+\" - сумма, \"-\" - разность");
                inputUser = inputData.readerDataString();
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
