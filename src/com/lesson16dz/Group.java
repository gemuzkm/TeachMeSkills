package com.lesson16dz;

import java.util.*;

public class Group {
    private int id;
    private String name;
    //ID студентов в группе
    private ArrayList<Integer> listIdStudentInGroup = new ArrayList<>();
    //ID всех групп
    public static ArrayList<Integer> listIdUGroup = new ArrayList<>();
    private Storage storage = new Storage();

    public Group() {
    }

    public Group(int id, String name, ArrayList<Integer> listIdStudentInGroup) {
        this.id = id;
        this.name = name;
        this.listIdStudentInGroup = listIdStudentInGroup;
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

    public ArrayList<Integer> getListIdStudentInGroup() {
        return listIdStudentInGroup;
    }

    public void setListIdStudentInGroup(ArrayList<Integer> listIdStudentInGroup) {
        this.listIdStudentInGroup = listIdStudentInGroup;
    }

    public static ArrayList<Integer> getListIdUGroup() {
        return listIdUGroup;
    }

    public static void setListIdUGroup(ArrayList<Integer> listIdUGroup) {
        Group.listIdUGroup = listIdUGroup;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", listIdStudentInGroup=" + listIdStudentInGroup +
                '}';
    }

    public void addGroup() {
        System.out.println("\nДобавление груп....\n");

        Group group1 = new Group(0, "group1", new ArrayList<>(List.of(0, 1)));
        storage.add(group1);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Group group2 = new Group(1, "group2", new ArrayList<>(List.of(2, 3)));
        storage.add(group2);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Group group3 = new Group(2, "group3", new ArrayList<>(List.of(4, 5)));
        storage.add(group3);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Group group4 = new Group(3, "group4", new ArrayList<>(List.of(6, 7, 8)));
        storage.add(group4);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Group group5 = new Group(3, "group5", new ArrayList<>(List.of(8)));
        storage.add(group5);
    }

    public void printAllGroupInformation() {
        storage.printAllGroups();
    }

    public void countingAverageRating() {
        System.out.println("\nСредний рейтинг группы\n");
        double averageGroup = 0;

        if (listIdUGroup.size() == 0) {
            System.out.println("В базе нет групп\n");
        } else {
            for (Integer idGroup : listIdUGroup) {
                Group group = storage.getGroup(idGroup);
                ArrayList<Integer> listAllGradesStudents = new ArrayList<>();
                ArrayList<Integer> listStudent = group.getListIdStudentInGroup();
                for (int i = 0; i < listStudent.size(); i++) {
                    listAllGradesStudents.addAll(storage.getStudentFromId(listStudent.get(i)).getListStudentGrades());
                }

                OptionalDouble average = listAllGradesStudents.stream().mapToDouble(e -> e).average();
                if (average.isPresent()) {
                    averageGroup = average.getAsDouble();
                }
                System.out.println("ID - " + group.getId() + ", название - " + group.getName() +
                        ", средний рейтинг - " + averageGroup);
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
