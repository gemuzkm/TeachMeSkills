package com.project.Calculator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InputData {

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    // Проверка строки на число. Работает для целых и вещественных.
    public boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public String readerDataString() {
        try {
            return reader.readLine();
        } catch (Exception e) {
            System.out.println("Что-то сломалось при вводе");
            readerClose();
            System.exit(0);
        }
        return null;
    }

    public void readerClose() {
        try {
            reader.close();
        } catch (Exception e) {
        }
    }
}