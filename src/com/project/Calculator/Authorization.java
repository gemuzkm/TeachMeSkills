package com.project.Calculator;

import java.io.IOException;

public class Authorization {
        private String userName;
        private String userPass;
        private static boolean isLogin;
        private boolean isRregistration;

        private InputData inputData = new InputData();
        private Store store = new Store();

        public void registration() throws IOException {
            while (!isRregistration) {
                System.out.println("\nВведите имя пользователя:");

                userName = inputData.readerDataString();

                if (store.сheckUser(userName)) {
                    System.out.println("Введенное имя пользователя занято");
                } else {
                    System.out.println("Введите пароль:");

                    userPass = inputData.readerDataString();

                    store.addNewUser(userName, userPass);
                    isRregistration = true;

                    System.out.println("\nНовый пользователь успешно создан!\n");
                }
            }
        }

        public void login() throws IOException {
            System.out.println("\nВведите имя пользователя:");

            userName = inputData.readerDataString();

            System.out.println("Введите пароль:");

            userPass = inputData.readerDataString();

            if (store.сheckUserPass(userName, userPass)) {
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
