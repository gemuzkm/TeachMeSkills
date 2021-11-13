package com.project.Calculator;

import java.io.IOException;

public class Calculator {
    public static void main(String[] args) throws IOException {
        Menu menu = new Menu();

        menu.showTitle();

        while (true) {
            menu.showMenu();
            menu.selectMenu();
        }
    }
}
