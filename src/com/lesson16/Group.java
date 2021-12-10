package com.lesson16;

import java.util.List;

public class Group {
    private String name;
    private List<Person> members;

    public Group() {
    }

    public Group(String name, List<Person> members) {
        this.name = name;
        this.members = members;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getMembers() {
        return members;
    }

    public void setMembers(List<Person> members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return "Groupe{" +
                "name='" + name + '\'' +
                ", member=" + members +
                '}';
    }
}
