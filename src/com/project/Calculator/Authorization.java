package com.project.Calculator;

public class Authorization {
        private String userName;
        private String userPass;
        private static boolean isLogin;
        private boolean isRregistration;

        private InputData inputData = new InputData();
        private Store store = new Store();

        public void registration() {
            while (!isRregistration) {
                System.out.println("\nВведите имя пользователя:");
                userName = inputData.readerDataString();
                if (userName.length() < 2) { //проверка на минимальную длину имени
                    System.out.println("Имя не может быть короче двух символов");
                } else {
                    if (store.сheckUser(userName)) { //проверка есть ли уже такой юзер
                        System.out.println("Введенное имя пользователя занято");
                    } else {
                        System.out.println("Введите пароль:");
                        userPass = inputData.readerDataString();
                            if (userPass.length() < 2) {
                                System.out.println("Пароль не может быть короче двух символов. Повтори регистрацию.");
                            } else {
                                store.addNewUser(userName, userPass);
                                isRregistration = true;
                                System.out.println("\nНовый пользователь успешно создан!\n");
                            }

                    }
                }

            }
        }

        public void login() {
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
