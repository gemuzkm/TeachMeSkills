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

    public String readerDataString() throws IOException {
        String inputDate = reader.readLine();
        return inputDate;
    }

    public void readerClose() throws IOException {
        reader.close();
    }
}