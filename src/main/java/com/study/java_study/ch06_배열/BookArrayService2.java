package com.study.java_study.ch06_배열;

import java.awt.print.Book;
import java.util.Scanner;

public class BookArrayService2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        BookArrayUtils bookArrayUtils = new BookArrayUtils();

        String[] books = new String[0];
        int findIndex = -1;
        boolean isRun = true;

        while(isRun) {
            System.out.println("[책 목록 관리 프로그램]");
            System.out.println("1. 책 추가");
            System.out.println("2. 책 수정");
            System.out.println("3. 책 삭제");
            System.out.println("4. 책 찾기");
            System.out.println("5. 책 목록 전체 조회");
            System.out.println("q. 프로그램 종료");

            String selectedMenu = scanner.nextLine();
            String[] newbooks = null;

            switch (selectedMenu) {
                case "1" :
                    System.out.println("[책 추가]");
                    newbooks = new String[books.length + 1];

                    for(int i = 0; i < books.length; i++) {
                        newbooks[i] = books[i];
                    }
                    books = newbooks;
                    System.out.println("추가할 책 제목: ");
                    books[books.length - 1] = scanner.nextLine();
                    System.out.println("추가 완료!");
                    break;
                case "2" :
                    System.out.println("[책 수정]");
                    System.out.println("수정할 책 제목: ");
                    String modifyBook = scanner.nextLine();
                    findIndex = bookArrayUtils.findIndexByBook(books, modifyBook);

                    if(findIndex == -1) {
                        System.out.println("책을 찾을 수 없습니다.");
                        break;
                    }
                    System.out.println("새로운 책 제목: ");
                    books[findIndex] = scanner.nextLine();
                    System.out.println("수정 완료");
                    break;
                case "3" :
                    System.out.println("[책 삭제]");
                    System.out.println("삭제할 책 제목: ");
                    String delBook = scanner.nextLine();
                    findIndex = bookArrayUtils.findIndexByBook(books, delBook);

                    if(findIndex == -1) {
                        System.out.println("책을 찾을 수 없습니다.");
                        break;
                     }
                    newbooks = new String[books.length -1];
                    for(int i = 0; i < newbooks.length; i++) {
                        if(i < findIndex) {
                            newbooks[i] = books[i];
                        }
                        newbooks[i] = books[i + 1];
                    }
                    books = newbooks;
                    System.out.println("삭제 완료");
                    break;
                case "4" :
                    System.out.println("책 찾기");
                    System.out.println("찾을 책 제목: ");
                    String findBook = scanner.nextLine();
                    findIndex = bookArrayUtils.findIndexByBook(books, findBook);

                    if(findIndex == -1) {
                        System.out.println("책을 찾을 수 없습니다.");
                        break;
                    }
                    System.out.println(books[findIndex] + "는 등록된 책입니다.");
                    break;
                case "5" :
                    break;
                case "q" :
                    isRun = false;
                    break;
                default :
            }
        }
    }
}
