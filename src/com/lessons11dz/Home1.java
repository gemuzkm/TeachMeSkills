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
                oneWord = bufferedReader.readLine().trim();
                if (isPolyndrome(oneWord)) {
                    bufferedWriter.write(oneWord + "\n"); //с новой строки, для читабильности
                }
          }
        } catch (IOException e) {
        }
    }

    public static boolean isPolyndrome(String oneWord) {
        StringBuilder oneWordRevers = new StringBuilder(oneWord);
        oneWord = oneWordRevers.toString();
        oneWordRevers.reverse();
        if (oneWordRevers.toString().equals(oneWord)) {
            return true;
        }
        return false;
    }
}
