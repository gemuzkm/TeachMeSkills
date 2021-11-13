package com.project.Calculator;

import java.io.IOException;

public class Calculator {
    public static void main(String[] args) throws IOException {
        MainMenu mainMenu = new MainMenu();
        AuthorizationMenu authorizationMenu = new AuthorizationMenu();
        Authorization authorization = new Authorization();

        authorizationMenu.showTitle();

        while (!authorization.islogin()) {
            authorizationMenu.showMenu();
            authorizationMenu.selectMenu();
        }

        mainMenu.showTitle();

        while (true) {
            mainMenu.showMenu();
            mainMenu.selectMenu();
        }
    }
}
