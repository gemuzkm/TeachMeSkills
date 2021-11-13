package com.project.Calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputData {
    private String inputA;
    private String inputB;

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static boolean isNumericInteger(String str)
    {
        try
        {
            int d = Integer.parseInt(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }

    public static boolean isNumericDouble(String str)
    {
        try
        {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }

    public static String readerData() throws IOException {
        String inputDate = reader.readLine();
        return inputDate;
    }
}
