package com.lessons11dz;

/*
1)В исходном файле находятся слова, каждое слово на новой стороке. После запуска программы должен создать файл,
который будет содержать в себе только полиндромы
 */

import java.io.*;

public class Home1 {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/com/lessons11dz/home1Read.txt"));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/com/lessons11dz/home1Write.txt"))) {

            String oneWord = "";
            while (bufferedReader.ready()) {
                StringBuilder oneWordRevers = new StringBuilder(bufferedReader.readLine().trim());
                oneWord = oneWordRevers.toString();
                oneWordRevers.reverse();
                if (oneWordRevers.toString().equals(oneWord)) {
                    bufferedWriter.write(oneWord + "\n");
                }
            }
        } catch (IOException e) {
        }
    }
}
