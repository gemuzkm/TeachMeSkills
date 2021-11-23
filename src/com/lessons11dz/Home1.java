package com.lessons11dz;

/*
1)В исходном файле находятся слова, каждое слово на новой стороке. После запуска программы должен создать файл,
который будет содержать в себе только полиндромы


 */

import java.io.*;

public class Home1 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("testFile.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("testOut1.txt"))) {

            String readeLineReverse = "";
            while (reader.ready()) {
                StringBuilder readeLine = new StringBuilder(reader.readLine().trim());
                 readeLineReverse = readeLine.reverse().toString().trim();
                 if (readeLine.toString().equals(readeLineReverse)) {
                     writer.write(readeLine.toString() + "\n");
                 }
            }
        } catch (IOException e) {

        }
    }
}
