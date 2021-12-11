package com.lesson16dz;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Storage {
    private String fileNameUniversity = "src/com/lesson16dz/university.json";
    private String fileNameGroups = "src/com/lesson16dz/group.json";
    private String fileNameStudents = "src/com/lesson16dz/student.json";

    private ObjectMapper objectMapper = new ObjectMapper();
    private FileWriter fileWriterStudent;
    private FileWriter fileWriterGroups;
    private FileWriter fileWriterUniversity;


    public void add(Student student) {
        if (Student.listIdStudents.contains(student.getId())) {
            System.out.println("Студет с таким ID = " + student.getId() + " уже существует\n");
        } else {
            //Если уже такой файл есть, то удаляем, т.к. в файл дописывается информация
            if (Student.listIdStudents.size() == 0) {
                File file = new File(fileNameStudents);
                if (file.length() > 0) {
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

    public Student getStudent(int idStudent) {
        return new Student();
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
                if (file.length() > 0) {
                    file.delete();
                }
            }
            Group.listIdUGroup.add(group.getId());

            try {
                String json = objectMapper.writeValueAsString(group);

                //В файл дописывываются данные
                fileWriterGroups = new FileWriter(new File(fileNameGroups),true);
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
                if (file.length() > 0) {
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
