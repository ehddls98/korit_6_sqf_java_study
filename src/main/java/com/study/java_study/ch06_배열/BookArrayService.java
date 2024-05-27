package com.study.java_study.ch06_배열;

import java.util.Scanner;

public class BookArrayService {

    public static void main(String[] args) {
        BookArrayUtils bookArrayUtils = new BookArrayUtils();
        Scanner scanner = new Scanner(System.in);

        String books[] = new String[0];
        boolean isRun = true;

        while(isRun) {
            System.out.println("[책 목록 관리 프로그램]");
            System.out.println("1. 책 등록");
            System.out.println("2. 책 목록 수정");
            System.out.println("3. 책 삭제");
            System.out.println("4. 책 찾기");
            System.out.println("5. 책 목록 조회");
            System.out.println("q. 프로그램 종료");
            System.out.print("메뉴 선택: ");

            String selectedMenu = scanner.nextLine();

            String newBooks[] = null;
            int findIndex = -1;

            switch (selectedMenu) {
                case "1" :
                    System.out.println("[책 등록]");
                    newBooks = new String[books.length + 1];
                    for(int i = 0; i < books.length; i++) {
                        newBooks[i] = books[i];
                    }
                    books = newBooks;
                    System.out.print("등록할 책의 제목: ");
                    books[books.length - 1] = scanner.nextLine();
                    System.out.println("등록 완료!");
                    break;
                case "2" :
                    System.out.println("[책 목록 수정]");
                    System.out.print("수정할 책 제목: ");
                    String modifyTitle = scanner.nextLine();
                    findIndex = bookArrayUtils.findIndexByBook(books, modifyTitle);

                    if(findIndex == -1) {
                        System.out.println("책을 찾을 수 없습니다.");
                        break;
                    }
                    System.out.print("새로운 책 제목: ");
                    books[findIndex] = scanner.nextLine();
                    System.out.println("수정 완료!");
                    break;
                case "3" :
                    System.out.println("[책 삭제]");
                    System.out.print("삭제할 책 제목: ");
                    String removeTitle = scanner.nextLine();
                    findIndex = bookArrayUtils.findIndexByBook(books, removeTitle);

                    if (findIndex == -1) {
                        System.out.println("책을 찾을 수 없습니다.");
                        break;
                    }
                    newBooks = new String[books.length -1];
                    for(int i = 0; i < newBooks.length; i++) {
                        if(i < findIndex) {
                            newBooks[i] = books[i];
                            continue;
                        }
                        newBooks[i] = books[i + 1];
                    }
                    books = newBooks;
                    System.out.println(removeTitle + "을(를) 삭제하였습니다.");
                    break;
                case "4" :
                    System.out.println("[책 찾기]");
                    System.out.print("찾을 책 제목: ");
                    String findTitle = scanner.nextLine();

                    findIndex = bookArrayUtils.findIndexByBook(books, findTitle);

                    if(findIndex == -1) {
                        System.out.println("해당 책은 등록되어 있지 않습니다.");
                    }
                    System.out.println("해당 책은 등록되어 있습니다.");
                    break;
                case "5" :
                    System.out.println("[책 목록 조회]");
                    for(int i = 0; i < books.length; i++) {
                        System.out.println("[index: " + i + "]: " + books[i]);
                    }
                    break;
                case "q" :
                    isRun = false;
                    break;
                default:
            }
        }
    }
}
