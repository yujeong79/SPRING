package com.ssafy.ws;

import java.util.List;

public class Classroom {
    private String name; // 반 이름
    private List<Student> students; // 반에 속한 교육생들

    public Classroom() {
    }

    public Classroom(String name, List<Student> students) {
        this.name = name;
        this.students = students;
    }

    // getter, setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void info() {
        System.out.println(name + "의 교육생 명단");
        System.out.println("총 인원: " + students.size() + "명");
        System.out.println("-----------------------------------");
        for (Student student : students) {
            System.out.printf("교육생 학번: %d, 이름: %s\n", student.getId(), student.getName());
        }
        System.out.println("-----------------------------------");
    }
}
