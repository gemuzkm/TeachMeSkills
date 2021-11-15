package com.project.Calculator;

/*
- авторизация
-- пароли не шифруются
-- без сохранения, только на время работы ПО (файл/BD)

- нужно ли приводить все к double (жду ответа, не решено)
-- округление к int при делении (жду ответа, чтобы фиксить все и это метод)
 */

import java.io.IOException;

public class Calculator {
    public static void main(String[] args) {
        CalculatorMenu calculatorMenu = new CalculatorMenu();
        AuthorizationMenu authorizationMenu = new AuthorizationMenu();
        Authorization authorization = new Authorization();

        authorizationMenu.showTitle();

        while (!authorization.islogin()) {
            authorizationMenu.showMenu();
            authorizationMenu.selectMenu();
        }

        calculatorMenu.showTitle();

        while (true) {
            calculatorMenu.showMenu();
            calculatorMenu.selectMenu();
        }
    }
}
