package com.lesson16;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Person person = new Person(new Date(System.currentTimeMillis()), "test1", "test2");
        Person person1 = new Person(new Date(System.currentTimeMillis()), "test4", "test5");
        List<Person> list = new ArrayList<>();
        list.add(person);
        list.add(person1);
        Group group = new Group("group1", list);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writeValueAsString(group);
            Group group1 = objectMapper.readValue(json, Group.class);
            System.out.println(group1);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
