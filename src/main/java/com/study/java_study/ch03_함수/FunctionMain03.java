package com.study.java_study.ch03_함수;

public class FunctionMain03 {

    public static void main(String[] args) {
        Function03 fx = new Function03();

        fx.fx01(1234, "김동인", 26, "01011112222");

        Student student = new Student();
        student.studentCode = 1234;
        student.name = "김동인";
        student.age = 26;
        student.phone = "01011112222";

        fx.fx02(student);


    }
}
