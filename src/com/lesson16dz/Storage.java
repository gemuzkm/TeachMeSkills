package com.lesson16dz;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;

public class Storage {
    private String fileNameUniversity = "src/com/lesson16dz/university.json";
    private String fileNameGroups = "src/com/lesson16dz/group.json";
    private String fileNameStudents = "src/com/lesson16dz/student.json";

    private ObjectMapper objectMapper = new ObjectMapper();
    private FileWriter fileWriterStudent;
    private FileWriter fileWriterGroups;
    private FileWriter fileWriterUniversity;
    private FileReader fileReaderStudent;


    public void add(Student student) {
        if (Student.listIdStudents.contains(student.getId())) {
            System.out.println("Студет с таким ID = " + student.getId() + " уже существует\n");
        } else {
            //Если уже такой файл есть, то удаляем, т.к. в файл дописывается информация
            if (Student.listIdStudents.size() == 0) {
                File file = new File(fileNameStudents);
                if (file.exists()) {
                    file.delete();
                }
            }
            Student.listIdStudents.add(student.getId());

            try {
                String json = objectMapper.writeValueAsString(student);

                //В файл дописывываются данные
                fileWriterStudent = new FileWriter(new File(fileNameStudents), true);
                fileWriterStudent.write(json + "\n");
                fileWriterStudent.close();

                System.out.println(json);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Студент с ID = " + student.getId() + " успешно добавлен!\n");
        }
    }

    public void printAllStudents() {
        if (Student.listIdStudents.size() == 0) {
            System.out.println("В базе нет студентов");
        } else {
            File file = new File(fileNameStudents);
            if (!file.exists() || file.length() == 0) {
                System.out.println("В базе нет студентов");
            } else {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(fileNameStudents));
                    System.out.println("Вывод информации о всех студентах\n");
                    while (bufferedReader.ready()) {
                        String json = bufferedReader.readLine();
                        System.out.println(json);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Student getStudent(int idStudent) {
        if (Student.listIdStudents.contains(idStudent)) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(fileNameStudents));
                while (bufferedReader.ready()) {
                    String json = bufferedReader.readLine();
                    Student student = objectMapper.readValue(json, Student.class);
                    if (student.getId() == idStudent) {
                        return student;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Студента с данным ID не существует");
        }
        return new Student(-1, "", "", new ArrayList<>());
    }

    public void add(Group group) {
        if (Student.listIdStudents.size() == 0) {
            System.out.println("Группа не добавлена. Нужно добавить студентов\n");
        } else if (Group.listIdUGroup.contains(group.getId())) {
            System.out.println("Группа с таким ID = " + group.getId() + " уже существует\n");
        } else {

            //Если уже такой файл есть, то удаляем, т.к. в файл дописывается информация
            if (Group.listIdUGroup.size() == 0) {
                File file = new File(fileNameGroups);
                if (file.exists()) {
                    file.delete();
                }
            }
            Group.listIdUGroup.add(group.getId());

            try {
                String json = objectMapper.writeValueAsString(group);

                //В файл дописывываются данные
                fileWriterGroups = new FileWriter(new File(fileNameGroups), true);
                fileWriterGroups.write(json + "\n");
                fileWriterGroups.close();

                System.out.println(json);
            } catch (IOException e) {
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

            //Если уже такой файл есть, то удаляем, т.к. в файл дописывается информация
            if (University.listIdUniversity.size() == 0) {
                File file = new File(fileNameUniversity);
                if (file.exists()) {
                    file.delete();
                }
            }

            University.listIdUniversity.add(university.getId());
            ObjectMapper objectMapper = new ObjectMapper();

            try {
                String json = objectMapper.writeValueAsString(university);

                fileWriterUniversity = new FileWriter(new File(fileNameUniversity), true);
                fileWriterUniversity.write(json + "\n");
                fileWriterUniversity.close();

                System.out.println(json);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Университет с ID = " + university.getId() + " успешно добавлен!\n");
        }
    }

    public University getUniversity(int idUniversity) {
        return new University();
    }
}
