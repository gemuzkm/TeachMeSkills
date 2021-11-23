package com.lessons11dz;

public class TextFormater {
    public static int worldCout(String str) {
        String[] allWorld = str.split(" ");
        return allWorld.length;
    }

    public static boolean strIsPolyndrome (String str) {
        String[] allWorld = str.split(" ");
        for (String item : allWorld) {
            String readeLineReverse = "";
            StringBuilder readeLine = new StringBuilder(item.trim());
            readeLineReverse = readeLine.reverse().toString().trim();
            if (readeLine.toString().equals(readeLineReverse)) {
                return true;
            }
        }
        return false;
    }


}
