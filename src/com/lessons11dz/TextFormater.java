package com.lessons11dz;

public class TextFormater {
    public static int wordCount(String str) {
        String[] allWorld = str.trim().split(" ");
        return allWorld.length;
    }

    public static boolean strInPolyndrome(String str) {
        String[] arrayWorld = str.trim().split(" ");
        String oneWord = "";
        for (String item : arrayWorld) {
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
