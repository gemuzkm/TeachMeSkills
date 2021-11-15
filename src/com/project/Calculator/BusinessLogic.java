package com.project.Calculator;

public class BusinessLogic {
    private CalculatorMenu calculatorMenu = new CalculatorMenu();
    private AuthorizationMenu authorizationMenu = new AuthorizationMenu();
    private Authorization authorization = new Authorization();

    public void start() {
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
