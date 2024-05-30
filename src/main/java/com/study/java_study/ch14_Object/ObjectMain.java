package com.study.java_study.ch14_Object;

import java.util.Objects;

/*
    Object 클래스(최상위 클래스)
    1.

 */
public class ObjectMain {

    public static void main(String[] args) {
        Object object = new Object();
        Student student = new Student("김동인", 27);
        Student student2 = new Student("김동인", 27);

        Object[] objects = new Object[3];
        objects[0] = new Object();
        objects[1] = "test";
        objects[2] = new Student("김동인", 27);

        System.out.println(student);
        String str = new String("데이터");
        System.out.println(str.toString());

        String studentData = student.toString();

        System.out.println(student.equals(student2));

        System.out.println(student.hashCode());
        System.out.println(student2.hashCode());

        System.out.println(student.hashCode() == student2.hashCode());
        System.out.println(Objects.hash("김동인"));
        System.out.println(Objects.hash("김동인"));

    }
}
