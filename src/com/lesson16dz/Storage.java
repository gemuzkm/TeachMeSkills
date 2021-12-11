package com.lesson16dz;

public class Storage {
    private String fileNameUniversity = "src/com/lesson16dz/university.json";
    private String fileNameGroups = "src/com/lesson16dz/group.json";
    private String fileNameStudents = "src/com/lesson16dz/student.json";

    public void add(Student student) {
        if (Student.listIdStudents.contains(student.getId()))  {
            System.out.println("Студет с таким ID = "+ student.getId() + " уже существует\n");
        } else {
            Student.listIdStudents.add(student.getId());
            System.out.println("Студент с ID = " + student.getId() + " успешно добавлен!\n");
        }
    }

    public Student getStudent (int idStudent) {
        return new Student();
    }

    public void add(Group group) {

    }

    public Group getGroup(int idGroup) {
        return new Group();
    }

    public void add(University university) {

    }

    public University getUniversity(int idUniversity) {
        return new University();
    }
}
