package com.project;

import java.io.IOException;

public class CalculatorMain {
    public static void main(String[] args) throws IOException {
//        History.addHistory("1");
//        History.addHistory("2");
        Menu.showTitle();
        while (true) {
            Menu.showMenu();
            Menu.selectMenu();
        }
    }
}
