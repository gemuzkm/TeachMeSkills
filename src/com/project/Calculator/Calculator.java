package com.project.Calculator;

import java.io.IOException;

public class Calculator {
    public static void main(String[] args) throws IOException {
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
