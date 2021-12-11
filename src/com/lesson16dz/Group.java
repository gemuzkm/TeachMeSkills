package com.lesson16dz;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Group {
    private int id;
    private String name;
    private Set<Integer> listIdStudentInGroup = new HashSet<>();
    public static Set<Integer> listIdUGroup = new HashSet<>();

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
                ", listStudent=" + listIdStudentInGroup +
                '}';
    }

    public void addGroup () {
        System.out.println("\nДобавление груп....\n");

        Group group1 = new Group(0, "group1", new HashSet<>(List.of(0,3)));
        System.out.println(group1.toString());

    }
}
