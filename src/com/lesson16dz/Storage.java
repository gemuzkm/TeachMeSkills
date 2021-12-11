package com.lesson16dz;

public class Storage {
    private String fileNameUniversity = "src/com/lesson16dz/university.json";
    private String fileNameGroups = "src/com/lesson16dz/group.json";
    private String fileNameStudents = "src/com/lesson16dz/student.json";

    public void add(Student student) {
        if (Student.listIdStudents.size() == 0) {
            Student.listIdStudents.add(student.getId());
        } else if (Student.listIdStudents.contains(student.getId()))  {
            System.out.println("\nСтудет с таким ID = "+ student.getId() + " уже существует\n");
        } else {
            Student.listIdStudents.add(student.getId());
        }
    }

    public void add(Group group) {

    }

    public void add(University university) {

    }
}
