package com.project.Calculator;

public class Authorization {
    private String userName;
    private String userPassword;
    private static boolean isLogin;

    private InputData inputData = new InputData();
    private Store store = new Store();

    public void registrationUser() {
        boolean isGoodUserName = false;
        boolean isGoodUserPassword = false;

        while (!isGoodUserName) {
            System.out.println("\nВведите имя пользователя:");
            userName = inputData.readerDataString();
            if (userName.length() < 2) { //проверка на минимальную длину имени
                System.out.println("Имя не может быть короче двух символов");
            } else if (store.сheckUser(userName)) { //проверка есть ли уже такой юзер
                System.out.println("Введенное имя пользователя занято");
            } else {
                isGoodUserName = true;
            }
        }

        while (!isGoodUserPassword) {
            System.out.println("\nВведите пароль:");
            userPassword = inputData.readerDataString();
            if (userPassword.length() < 2) {
                System.out.println("Пароль не может быть короче двух символов");
            } else {
                isGoodUserPassword = true;
            }
        }

        store.addNewUser(userName, userPassword); // нет проверки успешности, но с БД это реализуется
        System.out.println("\nНовый пользователь успешно создан!\n");
    }

    public void loginUser() {
        boolean isGoodUserName = false;
        boolean isGoodUserPassword = false;

        while (!isGoodUserName) {
            System.out.println("\nВведите имя пользователя:");
            userName = inputData.readerDataString();

            if (userName.equals("")) {
                System.out.println("Имя пользователя не может быть пустым");
            } else {
                isGoodUserName = true;
            }
        }

        while (!isGoodUserPassword) {
            System.out.println("\nВведите пароль:");
            userPassword = inputData.readerDataString();

            if (userPassword.equals("")) {
                System.out.println("Пароль не может быть пустым");
            } else {
                isGoodUserPassword = true;
            }
        }

        if (store.сheckUserPass(userName, userPassword)) {
            System.out.println("\nАвторизация прошла успешно!\n");
            isLogin = true;
        } else {
            System.out.println("\nВведенные данные некоректны, попробуйте еще раз\n");
        }
    }

    public boolean islogin() {
        return isLogin;
    }
}
