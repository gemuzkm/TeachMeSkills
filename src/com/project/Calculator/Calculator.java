package com.project.Calculator;

import java.io.IOException;

public class Calculator {
    public static void main(String[] args) throws IOException {

        Menu.showTitle();
        while (true) {
            Menu.showMenu();
            Menu.selectMenu();
        }
    }
}
