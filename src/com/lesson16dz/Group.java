package com.lesson16dz;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Group {
    private int id;
    private String name;
    private Set<Integer> listIdStudentInGroup = new HashSet<>();
    public static Set<Integer> listIdUGroup = new HashSet<>();
    private Storage storage = new Storage();

    public Group() {
    }

    public Group(int id, String name, Set<Integer> listIdStudentInGroup) {
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

    public Set<Integer> getListIdStudentInGroup() {
        return listIdStudentInGroup;
    }

    public void setListIdStudentInGroup(Set<Integer> listIdStudentInGroup) {
        this.listIdStudentInGroup = listIdStudentInGroup;
    }

    public static Set<Integer> getListIdUGroup() {
        return listIdUGroup;
    }

    public static void setListIdUGroup(Set<Integer> listIdUGroup) {
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

    public void addGroup () {
        System.out.println("\nДобавление груп....\n");

        Group group1 = new Group(0, "group1", new HashSet<>(List.of(0,3)));
        System.out.println(group1.toString());
        storage.add(group1);

        Group group2 = new Group(1, "group2", new HashSet<>(List.of(0,3)));
        System.out.println(group2.toString());
        storage.add(group2);

        Group group3 = new Group(2, "group3", new HashSet<>(List.of(0,3)));
        System.out.println(group3.toString());
        storage.add(group3);

        Group group4 = new Group(3, "group4", new HashSet<>(List.of(0,3)));
        System.out.println(group4.toString());
        storage.add(group4);

        Group group5 = new Group(3, "group5", new HashSet<>(List.of(0,3)));
        System.out.println(group5.toString());
        storage.add(group5);

    }
}
