package com.project.Calculator;

public class CalculatorMenu implements Menu {

    private String selectMenu;
    private InputData inputData = new InputData();
    private CalculatorOperations calculatorOperations = new CalculatorOperations();
    private Store store = new Store();

    @Override
    public void showTitle() {
        System.out.println("Привет. Это приложение калькулятор. Оно готово к работе.\n");
    }

    @Override
    public void showMenu() {
        System.out.println("Нажмите \"1\" для выполнения арифметической опперации");
        System.out.println("Нажмите \"2\" для отображения истории операций");
        System.out.println("Нажмите \"3\" для выхода из приложения\n");
        System.out.println("Введите цифру нужного меню:");
    }

    @Override
    public void selectMenu() {
        selectMenu = inputData.readerDataString();

        if (selectMenu.equals("1")) {
            calculatorOperations.actions();
        } else if (selectMenu.equals("2")) {
            store.printHistory();
        } else if (selectMenu.equals("3")) {
            inputData.readerClose();
            System.exit(0);
        } else {
            System.out.println("\nТакого меню не существует. Выбери только из указанных вариантов\n");
        }
     }
}
