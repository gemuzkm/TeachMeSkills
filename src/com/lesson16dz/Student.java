package com.lesson16dz;

import java.util.*;

public class Student {
    private int id;
    private String firsName;
    private String lastName;
    private ArrayList<Integer> listStudentGrades;
    //ID всех студентов
    public static Set<Integer> listIdStudents = new HashSet<>();

    private Storage storage = new Storage();

    public Student() {
    }

    public Student(int id, String firsName, String lastName, ArrayList<Integer> listStudentGrades) {
        this.id = id;
        this.firsName = firsName;
        this.lastName = lastName;
        this.listStudentGrades = listStudentGrades;
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

    public ArrayList<Integer> getListStudentGrades() {
        return listStudentGrades;
    }

    public void setListStudentGrades(ArrayList<Integer> listStudentGrades) {
        this.listStudentGrades = listStudentGrades;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firsName='" + firsName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", listStudentGrades=" + listStudentGrades +
                '}';
    }

    public void addStudents() {
        System.out.println("\nДобавление студентов....\n");
        Student student1 = new Student(0, "studentFirstName1", "studentLastName1", new ArrayList<>(List.of(5,4,5,3,2)));
        storage.add(student1);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Student student2 = new Student(1, "studentFirstName2", "studentLastName2", new ArrayList<>(List.of(5,3,5,3,2)));
        storage.add(student2);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Student student3 = new Student(2, "studentFirstName3", "studentLastName3", new ArrayList<>(List.of(5,2,5,3,2)));
        storage.add(student3);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Student student4 = new Student(3, "studentFirstName4", "studentLastName4", new ArrayList<>(List.of(5,5,5,3,2)));
        storage.add(student4);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Student student5 = new Student(3, "studentFirstName5", "studentLastName5", new ArrayList<>(List.of(5,4,5,3,4)));
        storage.add(student5);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Student student6 = new Student(4, "studentFirstName6", "studentLastName6", new ArrayList<>(List.of(4,4,5,3,4)));
        storage.add(student6);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Student student7 = new Student(5, "studentFirstName7", "studentLastName7", new ArrayList<>(List.of(2,4,5,3,4)));
        storage.add(student7);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Student student8 = new Student(6, "studentFirstName8", "studentLastName8", new ArrayList<>(List.of(5,4,2,3,4)));
        storage.add(student8);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Student student9 = new Student(7, "studentFirstName7", "studentLastName7", new ArrayList<>(List.of(3,4,5,3,4)));
        storage.add(student9);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Student student10 = new Student(8, "studentFirstName8", "studentLastName8", new ArrayList<>(List.of(5,4,2,3,4)));
        storage.add(student10);
    }

    public void printAllStudentInformation() {
        storage.printAllStudents();
    }

    public void countingAverageRating() {
        if (listIdStudents.size() == 0) {
            System.out.println("\nВ базе нет студентов");
        } else {
            System.out.println("Средний рейтинг студентов\n");

            for (Integer idStudent : listIdStudents) {
                Student student = storage.getStudentFromId(idStudent);
//                double averageStudent = average(student.listStudentGrades);
                double averageStudent = 0;
                List<Integer> studentGrades = student.getListStudentGrades();
                OptionalDouble average  = studentGrades.stream().mapToInt(e -> e).average();
                if (average.isPresent()) {
                    averageStudent = average.getAsDouble();
                }

                System.out.println("ID - " + student.id + ", Имя: " + student.getFirsName() +
                        ", Фамилия - " + student.getLastName() + ", Рейтинг - " + averageStudent);
            }
        }
    }

//    private double average(ArrayList<Integer> list) {
//        double sum = 0;
//
//        for (Integer item: list) {
//            sum += item;
//        }
//        return sum / list.size();
//    }
}
