package com.lessons11dz;

/*
2)Текстовый файл содержит текст. После запуска программы в другой файл должны записаться
только те предложения в которых от 3-х до 5-ти слов. Если в
предложении присутствует слово-палиндром, то не имеет значения какое кол-во слов в предложении, оно попадает в новый файл.
Пишем все в ООП стиле. Создаём класс TextFormater
в котором два статических метода:
1. Метод принимает строку и возвращает кол-во слов в строке.
2. Метод принимает строку и проверяет есть ли в строке слово-палиндром. Если есть возвращает true, если нет false
В main считываем файл. Разбиваем текст на предложения. Используя методы класса TextFormater определяем подходит
ли нам предложение. Если подходит добавляем его в новый файл
 */

import java.io.*;

public class Home2 {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/com/lessons11dz/home2Read.txt"));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/com/lessons11dz/home2Write.txt"))) {
            String allText = "";

            while (bufferedReader.ready()) {
                allText += bufferedReader.readLine();
            }

            String[] arrayText = allText.split("\\.");
            int countWorld = 0;

            for (int i = 0; i < arrayText.length; i++) {
                countWorld = TextFormater.worldCount(arrayText[i]);
                if (countWorld >= 3 && countWorld <= 5 || TextFormater.strInPolyndrome(arrayText[i])) {
                    bufferedWriter.write(arrayText[i].trim() + ".\n"); //запись с новой строки, для наглядности
                }
            }
        } catch (IOException e) {
        }
    }
}
