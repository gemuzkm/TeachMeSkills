package com.lesson16dz;

import java.util.List;

public class University {
    private String name;
    private List<Group> listGroup;

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
}
