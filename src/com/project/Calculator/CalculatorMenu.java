package com.project.Calculator;

public class CalculatorMenu implements Menu {

    private String selectMenu;
    private InputData inputData = new InputData();

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
        selectMenu =  inputData.readerDataString();

        switch (selectMenu) {
            case "1" :
                new CalculatorOperations().actions();
                break;
            case "2" :
                new Store().printHistory();
                break;
            case "3" :
                inputData.readerClose();
                System.exit(0);
            default:
                System.out.println("\nТакого меню не существует. Выбери только из указанных вариантов\n");
        }
    }
}
