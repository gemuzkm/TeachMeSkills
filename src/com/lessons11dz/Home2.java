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
        try (BufferedReader reader = new BufferedReader(new FileReader("testFile.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("testOut2.txt"))) {
            String allText = "";

            while (reader.ready()) {
                allText += reader.readLine();
            }

            String[] texеOffer = allText.split(".");

            for (int i = 0; i < texеOffer.length; i++) {
                if (TextFormater.worldCout(texеOffer[i]) >= 3 && TextFormater.worldCout(texеOffer[i]) <= 5) {
                    writer.write(texеOffer[i] + ". ");
                } else if (TextFormater.strIsPolyndrome(texеOffer[i])) {
                    writer.write(texеOffer[i] + ". ");
                }
            }

        } catch (IOException e) {

        }
    }
}
