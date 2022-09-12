package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private String name;
    private int age;

    private List<Student> students = new ArrayList<>();

    public List<Student> getStudents() { return students; }

    public void setStudents(List<Student> students) { this.students = students; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }

    public University(String name, int age) {
        this.name = name; this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        //TODO:

        students = getStudents();
        for (int i = 0; i < students.size(); i++) {
            double tempGrade = students.get(i).getAverageGrade();
            if (tempGrade == averageGrade) {
                return students.get(i);
            }
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:

        students = getStudents();
        double maxGrade = students.get(0).getAverageGrade();
        Student maxStudent = students.get(0);
        for (int i = 1; i < students.size(); i++) {
            double tempGrade = students.get(i).getAverageGrade();
            if (tempGrade > maxGrade) {
                maxGrade = tempGrade;
                maxStudent = students.get(i);
            }
        }
        return maxStudent;
    }

    public void expel(Student student) {
        //TODO:
        students = getStudents();
        students.remove(student);
    }

    public Student getStudentWithMinAverageGrade () {
        students = getStudents();
        double minGrade = students.get(0).getAverageGrade();
        Student minStudent = students.get(0);
        for (int i = 1; i < students.size(); i++) {
            double tempGrade = students.get(i).getAverageGrade();
            if (tempGrade < minGrade) {
                minGrade = tempGrade;
                minStudent = students.get(i);
            }
        }
        return minStudent;
    }
}