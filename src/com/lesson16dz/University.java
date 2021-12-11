package com.lesson16dz;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class University {
    private int id;
    private String name;
    private Set<Integer> listIdGroupInUniversity = new HashSet<>();

    private Storage storage = new Storage();
    public static Set<Integer> listIdUniversity = new HashSet<>();

    public University() {
    }

    public University(int id, String name, Set<Integer> listIdGroupInUniversity) {
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

    public Set<Integer> getListIdGroupInUniversity() {
        return listIdGroupInUniversity;
    }

    public void setListIdGroupInUniversity(Set<Integer> listIdGroupInUniversity) {
        this.listIdGroupInUniversity = listIdGroupInUniversity;
    }

    public void addUniversity() {
        System.out.println("\nДобавление университетов....\n");

        University university1 = new University(0, "university1", new HashSet<>(List.of(0,1)));
        storage.add(university1);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        University university2 = new University(1, "university2", new HashSet<>(List.of(2,3)));
        storage.add(university2);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        University university3 = new University(2, "university3", new HashSet<>(List.of(4)));
        storage.add(university3);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        University university4 = new University(2, "university4", new HashSet<>(List.of(4)));
        storage.add(university4);
    }
}
