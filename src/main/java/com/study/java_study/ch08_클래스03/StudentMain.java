package com.study.java_study.ch08_클래스03;

public class StudentMain {

    public static void main(String[] args) {

        int[] numbers = new int[5];
        numbers[0] = 10;

        Student[] students = new Student[3];
        students[0] = new Student(20240501, "김동인", 27);
        students[1] = new Student(20240502, "김서인", 28);
        students[2] = new Student(20240503, "김남인", 29);

        Student[] studentss = new Student[] {
                new Student(20240501, "김동인", 27),
                new Student(20240502, "김서인", 28),
                new Student(20240503, "김남인", 29)
        };

        for(int i = 0; i < students.length; i++) {
//            if(students[i] == null) {
//                continue;
//            }
            System.out.println("학번: " + students[i].getCode());
            System.out.println("이름: " + students[i].getName());
            System.out.println("나이: " + students[i].getAge());
            System.out.println();
        }
    }
}
