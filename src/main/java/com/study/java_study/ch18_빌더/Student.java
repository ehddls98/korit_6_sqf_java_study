package com.study.java_study.ch18_빌더;

public class Student {

    private int studentCode;
    private String name;
    private int age;

    public Student(int studentCode, String name, int age) {
        this.studentCode = studentCode;
        this.name = name;
        this.age = age;
    }

    public static StudentBuilder builder() { //StudentBuilder 객체를 생성하는 스태틱 클래스
        return new StudentBuilder();
    }

    public static class StudentBuilder {
        private int studentCode;
        private String name;
        private int age;

        public Student build() { //아래 메서드들(studentCode, name, age)에서 받은 값들을 가지는 Student 객체를 생성하는 메서드
            return new Student(studentCode, name, age);
        }

        public StudentBuilder studentCode(int studentCode) { //파라미터로 받은 studentCode를 Student 객체의 studentCode에 대입하는 메서드
            this.studentCode = studentCode;
            return this;
        }

        public StudentBuilder name(String name) { //파라미터로 받은 name을 Student 객체의 name에 대입하는 메서드
            this.name = name;
            return this;
        }

        public StudentBuilder age(int age) { //파라미터로 받은 age를 Student 객체의 age에 대입하는 메서드
            this.age = age;
            return this;
        }
    }
}
