package com.project.ToDoList.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReaderDataFromConsole {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public String readString() {
        String inputDate = "";
        try  {
            inputDate = reader.readLine().trim();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputDate;
    }

    public void readerClose () {
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
