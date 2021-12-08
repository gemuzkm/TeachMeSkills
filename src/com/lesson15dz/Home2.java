package com.lesson15dz;
/*
2) Написать регулярное выражение для проверки правильности ввода email. Email считается валидным, если у него есть '@что-то.что-то'
*/

import javax.swing.text.html.parser.Parser;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Home2 {
    public static void main(String[] args) {
        List<String> listMail = new ArrayList<>();

        listMail.add(" s das ad a@gmail.ru");
        listMail.add("dasdasd@ mail.ru");
        listMail.add("asdasdasd@gmail.com");
        listMail.add("griinfewi@gmailc .com");
        listMail.add(" s123dds@gmail.com  ");
        listMail.add(" s123dds@123123..com  ");
        listMail.add(" 111111@@123123.com  ");
        listMail.add(" s123dds@gmail.123  ");
        listMail.add(" 123123@123123.123  ");

        Pattern parrentMail = Pattern.compile("^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z]+");

        for (String itemMail: listMail) {
            Matcher matcherMail = parrentMail.matcher(itemMail.trim());
            if (matcherMail.find()) {
                System.out.println(itemMail.trim());
            }
        }
    }
}
