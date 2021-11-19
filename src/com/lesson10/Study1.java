package com.lesson10;

public class Study1 {
    public static void main(String[] args) {
        String a = null;
        try {
            a.isEmpty();

        } catch (NullPointerException e)  {
            System.out.println("NPE");
        }

        catch (Exception e) {
            System.out.println("Exception");
        } finally {
            System.out.println("finally");
        }

    }
}
