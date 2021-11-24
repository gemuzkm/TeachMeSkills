package com.lessons11dz;

public class TextFormater {
    public static int wordCount(String str) {
        String[] allWord = str.trim().split(" ");
        return allWord.length;
    }

    public static boolean strInPolyndrome(String str) {
        String[] arrayWord = str.trim().split(" ");
        String oneWord = "";
        for (String item : arrayWord) {
            StringBuilder oneWordRevers = new StringBuilder(item.trim());
            oneWord = oneWordRevers.toString();
            oneWordRevers.reverse();
            if (oneWordRevers.toString().equals(oneWord)) {
                return true;
            }
        }
        return false;
    }
}
