package org.example.sem_3_Serializable.student_serial;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private int age;
    private transient double GPA;

    public Student(String name, int age, double GPA) {
        this.name = name;
        this.age = age;
        this.GPA = GPA;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGPA() {
        return GPA;
    }

    @Override
    public String toString() {
        return "Студент " + "||" +
                " имя " + name + " ||" +
                " возраст " + age + " ||" +
                " средний бал " + GPA +
                " ";
    }
}