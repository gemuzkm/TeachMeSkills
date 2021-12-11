package com.lesson16dz;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Student {
    private int id;
    private String firsName;
    private String lastName;
    private List<Integer> listRatings;
    public static Set<Integer> listIdStudents = new HashSet<>();

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
        System.out.println("\nДобавление студентов....\n");
        Student student1 = new Student(0, "studentFirstName1", "studentLastName1", new ArrayList<>(List.of(5,4,5,3,2)));
        System.out.println(student1.toString());
        storage.add(student1);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Student student2 = new Student(1, "studentFirstName2", "studentLastName2", new ArrayList<>(List.of(5,3,5,3,2)));
        System.out.println(student2.toString());
        storage.add(student2);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Student student3 = new Student(2, "studentFirstName3", "studentLastName3", new ArrayList<>(List.of(5,2,5,3,2)));
        System.out.println(student3.toString());
        storage.add(student3);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Student student4 = new Student(3, "studentFirstName4", "studentLastName4", new ArrayList<>(List.of(5,5,5,3,2)));
        System.out.println(student4.toString());
        storage.add(student4);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Student student5 = new Student(3, "studentFirstName5", "studentLastName5", new ArrayList<>(List.of(5,4,5,3,4)));
        System.out.println(student5.toString());
        storage.add(student5);

//        listIdStudents.stream().forEach(x -> System.out.print(x + " "));
    }
}
