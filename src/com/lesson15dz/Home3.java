package com.lesson15dz;

/*
3) В переменную присвоить какой либо текст на несколько предложений. Написать регулярки,
которые будут находить первые и последние слова предложений
 */

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Home3 {
    public static void main(String[] args) {
        List<String> listLine = new ArrayList<>();

        listLine.add("asdasdasd asd as dasdasdasd. asdasdasd  asd a sd a sd a sd a s d as d as dasdasdasd. asdasdasd asd as dasdasdasd.");


        Pattern patternFirst = Pattern.compile("");
        Pattern patternLast = Pattern.compile("");

        for (String itemLine: listLine) {
            Matcher matcherLine = patternFirst.matcher(itemLine.trim());
            if (matcherLine.find()) {
                System.out.println(matcherLine.group());
            }
        }


    }
}
