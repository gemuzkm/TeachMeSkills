package com.project.Calculator;

public class CalculatorOperations {
    private static boolean isDouble;
    private static double firstNumber;
    private static double secondNumber;
    private static String inputUserData;

    private Store store = new Store();
    private InputData inputData = new InputData();

    public void actions() {
        actionFirstNumber();
        actionSecondNumber();
        actionOperation();
    }

    private void actionFirstNumber() {
        System.out.println("Введи первое число");
        inputUserData = inputData.readerDataString();

        boolean isString = true;

        while (isString) {

            if (inputData.isNumeric(inputUserData)) {
                isString = false;
                firstNumber = Double.parseDouble(inputUserData);
            }

            if (isString) {
                System.out.println("Ввведи первое число");
                inputUserData = inputData.readerDataString();
            }
        }
    }

    private void actionSecondNumber() {
        System.out.println("Введи второе число");
        inputUserData = inputData.readerDataString();
        boolean isString = true;

        while (isString) {
            if (inputData.isNumeric(inputUserData)) {
                isString = false;
                secondNumber = Double.parseDouble(inputUserData);
            }

            if (isString) {
                System.out.println("Ввведи второе число");
                inputUserData = inputData.readerDataString();
            }
        }
    }

    private void resultOperation(String inputOperation) {
        if (inputOperation.trim().equals("+")) {
            double sumResult = firstNumber + secondNumber;
            store.addHistory(String.valueOf(sumResult));
            System.out.println("Результат опперации: " + sumResult + "\n");
         }

        if (inputOperation.trim().equals("-")) {
            double diffResult = firstNumber - secondNumber;
            store.addHistory(String.valueOf(diffResult));
            System.out.println("Результат опперации: " + diffResult + "\n");
         }

        if (inputOperation.trim().equals("*")) {
            double multiplyResult = firstNumber * secondNumber;
            store.addHistory(String.valueOf(multiplyResult));
            System.out.println("Результат опперации: " + multiplyResult + "\n");
        }

        if (inputOperation.trim().equals("/")) {
            if (secondNumber == 0.0) {
                System.out.println("\nОшибка! Деление на 0 невозможно!\n");
            } else {
                double divisionResult = firstNumber / secondNumber;
                store.addHistory(String.valueOf(divisionResult));
                System.out.println("Результат опперации: " + divisionResult + "\n");
            }
        }
    }

    private void actionOperation() {
        System.out.println("Введи нужную опперацию \"*\" - умножить, \"/\" - деление, \"+\" - сумма, \"-\" - разность");
        inputUserData = inputData.readerDataString();
        if (inputUserData.equals("*")) {
            resultOperation(inputUserData);
        } else if (inputUserData.equals("/")) {
            resultOperation(inputUserData);
        } else if (inputUserData.equals("-")) {
            resultOperation(inputUserData);
        } else if (inputUserData.equals("+")) {
            resultOperation(inputUserData);
        } else {
            System.out.println("Данная операция не поддерживается\n");
        }
    }
}
