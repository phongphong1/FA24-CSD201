/*
 * Copyright (C) 2024 HoangPhong. All Rights Reserved.
 */

package main;

public class Student {
    int id;
    String name;
    int age;

    public Student() {
    }

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "(" + id + ", " + name + ", " + age + ")";
    }
}
