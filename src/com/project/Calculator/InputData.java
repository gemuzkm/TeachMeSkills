package com.project.Calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputData {

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public boolean isNumericInteger(String str) {
        try {
            int d = Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public boolean isNumericDouble(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public String readerDataString() {
        String inputDate = "";
        try {
            inputDate = reader.readLine();
        } catch (Exception e) {

        }

        return inputDate;
    }

    public void readerClose() {
        try {
            reader.close();
        } catch (Exception e) {

        }
     }
}