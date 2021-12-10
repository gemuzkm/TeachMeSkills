package com.lesson16dz;

import java.util.List;

public class Student {
    private String firsName;
    private String lastName;
    private List<Integer> listRatings;

    public Student() {
    }

    public Student(String firsName, String lastName, List<Integer> listRatings) {
        this.firsName = firsName;
        this.lastName = lastName;
        this.listRatings = listRatings;

    }


}
