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

    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Integer> getListRatings() {
        return listRatings;
    }

    public void setListRatings(List<Integer> listRatings) {
        this.listRatings = listRatings;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firsName='" + firsName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", listRatings=" + listRatings +
                '}';
    }
}
