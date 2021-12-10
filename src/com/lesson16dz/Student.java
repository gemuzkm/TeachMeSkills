package com.lesson16dz;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private int id;
    private String firsName;
    private String lastName;
    private List<Integer> listRatings;

    private Storage storage = new Storage();

    public Student() {
    }

    public Student(int id, String firsName, String lastName, List<Integer> listRatings) {
        this.id = id;
        this.firsName = firsName;
        this.lastName = lastName;
        this.listRatings = listRatings;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                "id=" + id +
                ", firsName='" + firsName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", listRatings=" + listRatings +
                '}';
    }

    public void addStudents() {
        System.out.println("Добавление студентов....");
        Student student1 = new Student(0, "studentFirstName1", "studentLastName1", new ArrayList<>(List.of(5,4,5,3,2)));
        System.out.println(student1.toString());
    }
}
