package com.lesson16dz;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Storage {
    private String fileNameUniversity = "src/com/lesson16dz/university.json";
    private String fileNameGroups = "src/com/lesson16dz/group.json";
    private String fileNameStudents = "src/com/lesson16dz/student.json";

    public void add(Student student) {
        if (Student.listIdStudents.contains(student.getId())) {
            System.out.println("Студет с таким ID = " + student.getId() + " уже существует\n");
        } else {
            Student.listIdStudents.add(student.getId());
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                String json = objectMapper.writeValueAsString(student);
                System.out.println(json);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            System.out.println("Студент с ID = " + student.getId() + " успешно добавлен!\n");
        }
    }

    public Student getStudent(int idStudent) {
        return new Student();
    }

    public void add(Group group) {
        if (Student.listIdStudents.size() == 0) {
            System.out.println("Группа не добавлена. Нужно добавить студентов\n");
        } else if (Group.listIdUGroup.contains(group.getId())) {
            System.out.println("Группа с таким ID = " + group.getId() + " уже существует\n");
        } else {
            Group.listIdUGroup.add(group.getId());
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                String json = objectMapper.writeValueAsString(group);
                System.out.println(json);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            System.out.println("Группа с ID = " + group.getId() + " успешно добавлена!\n");
        }
    }

    public Group getGroup(int idGroup) {
        return new Group();
    }

    public void add(University university) {
        if (Group.listIdUGroup.size() == 0) {
            System.out.println("Университет не добавлен. Нужно добавить группы\n");
        } else if (University.listIdUniversity.contains(university.getId())) {
            System.out.println("Университет с таким ID = " + university.getId() + " уже существует\n");
        } else {
            University.listIdUniversity.add(university.getId());
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                String json = objectMapper.writeValueAsString(university);
                System.out.println(json);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            System.out.println("Университет с ID = " + university.getId() + " успешно добавлен!\n");
        }
    }

    public University getUniversity(int idUniversity) {
        return new University();
    }
}
