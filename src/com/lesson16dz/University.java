package com.lesson16dz;

import java.util.*;

public class University {
    private int id;
    private String name;
    private ArrayList<Integer> listIdGroupInUniversity = new ArrayList<>();

    private Storage storage = new Storage();
    public static ArrayList<Integer> listIdUniversity = new ArrayList<>();

    public University() {
    }

    public University(int id, String name, ArrayList<Integer> listIdGroupInUniversity) {
        this.id = id;
        this.name = name;
        this.listIdGroupInUniversity = listIdGroupInUniversity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Integer> getListIdGroupInUniversity() {
        return listIdGroupInUniversity;
    }

    public void setListIdGroupInUniversity(ArrayList<Integer> listIdGroupInUniversity) {
        this.listIdGroupInUniversity = listIdGroupInUniversity;
    }

    @Override
    public String toString() {
        return "University{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", listIdGroupInUniversity=" + listIdGroupInUniversity +
                '}';
    }

    public void addUniversity() {
        System.out.println("\nДобавление университетов....\n");

        University university1 = new University(0, "university1", new ArrayList<>(List.of(0)));
        storage.add(university1);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        University university2 = new University(1, "university2", new ArrayList<>(List.of(1,2)));
        storage.add(university2);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        University university3 = new University(2, "university3", new ArrayList<>(List.of(3)));
        storage.add(university3);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        University university4 = new University(2, "university4", new ArrayList<>(List.of(4)));
        storage.add(university4);
    }

    public void printAllUniversityInformation() {
        storage.printAllUniversity();
    }

    public void countingAverageRating() {
        System.out.println("\nСредний рейтинг университета\n");
        double averageUniversity = 0;

        if (listIdUniversity.size() == 0) {
            System.out.println("В базе нет групп\n");
        } else {
            for (Integer idUniversity: listIdUniversity) {
                University university = storage.getUniversity(idUniversity);
                ArrayList<Integer> listAllGradesStudents = new ArrayList<>();
                ArrayList<Integer> listIdAllStudentInUniversity = new ArrayList<>();
                ArrayList<Integer> listIdAllGroupInUniversity = university.getListIdGroupInUniversity();

                for (int i = 0; i < listIdAllGroupInUniversity.size(); i++) {
                    listIdAllStudentInUniversity.addAll(storage.getGroup(listIdAllGroupInUniversity.get(i)).getListIdStudentInGroup());
                }

                for (int i = 0; i < listIdAllStudentInUniversity.size(); i++) {
                    listAllGradesStudents.addAll(storage.getStudentFromId(listIdAllStudentInUniversity.get(i)).getListStudentGrades());
                }

                OptionalDouble average = listAllGradesStudents.stream().mapToDouble(e -> e).average();
                if (average.isPresent()) {
                    averageUniversity = average.getAsDouble();
                }

                System.out.println("ID - " + university.id + ", название - " + university.getName() +
                        ", рейтинг - " + averageUniversity);
            }
        }
    }
}
