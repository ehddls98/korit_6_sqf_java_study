package com.study.java_study.ch09_클래스04;

public class BookMain {

    public static void main(String[] args) {
        BookService bookService = new BookService();

        System.out.println("프로그램을 실행합니다.");

        while(bookService.run()) {} //bookService.run()이 true인 동안 동작한다.

        System.out.println("프로그램을 종료합니다.");
    }
}
