package com.lesson16dz;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class University {
    private String name;
    private List<Group> listGroup;
    public static Set<Integer> listIdUniversity = new HashSet<>();

    public University() {
    }

    public University(String name, List<Group> listGroup) {
        this.name = name;
        this.listGroup = listGroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Group> getListGroup() {
        return listGroup;
    }

    public void setListGroup(List<Group> listGroup) {
        this.listGroup = listGroup;
    }

    @Override
    public String toString() {
        return "University{" +
                "name='" + name + '\'' +
                ", listGroup=" + listGroup +
                '}';
    }

    public void addUniversity() {
        System.out.println("\nДобавление университетов....\n");


    }
}
