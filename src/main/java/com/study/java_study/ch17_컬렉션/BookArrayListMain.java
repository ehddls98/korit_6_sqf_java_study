package com.study.java_study.ch17_컬렉션;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookArrayListMain {

    public static void main(String[] args) {

        // 프로그램 시작
        // 도서명: 도서1
        // 저자명: 저자1
        // new Book("도서1", "저자1")
        // BookList에 추가

        // 도서명: 도서2
        // 저자명: 저자2
        // new Book("도서2", "저자2")
        // BookList에 추가

        // 도서명: 도서3
        // 저자명: 저자3
        // new Book("도서3", "저자3")
        // BookList에 추가

        //도서 전체 조회
        // 도서명 >> 도서1
        // 저자명 >> 저자1 //반복문 .get

        //삭제 할 도서명: 도서2

        //도서 전체 조회
        // 도서명 >> 도서1, 3
        // 저자명 >> 저자1, 3

        Scanner scanner = new Scanner(System.in);

        List<Book> bookList = new ArrayList<>();

        //도서 추가
        for(int i = 0; i < 3; i++) {
            String bookName;
            String author;
            System.out.print("도서명: ");
            bookName = scanner.nextLine();
            System.out.print("저자명: ");
            author = scanner.nextLine();

            bookList.add(new Book(bookName, author));
        }

        //도서 전체 조회
        for(Book book : bookList) {
            System.out.println("도서명: " + book.getBookName());
            System.out.println("도서명: " + book.getAuthor());
            System.out.println();
        }

        System.out.print("삭제할 도서명: ");
        String removeBookName = scanner.nextLine();
        //삭제1
        for(Book book : bookList) {
            if(book.getBookName().equals(removeBookName)) {
                bookList.remove(book); //list에서 remove를 하면 새로운 리스트를 생성하면서 주소값이 바뀌기 때문에 break를 걸어줘야 한다.
                                        //아니면 for : each를 돌리고 있는 리스트의 주소값이 바뀌면서 오류가 나게된다.
                break;
            }
        }
        //삭제2
        for(int i = 0; i < bookList.size(); i++) {
            if(bookList.get(i).getBookName().equals(removeBookName)) {
                Book removeBook = bookList.remove(i);
                System.out.println("삭제된 도서 정보: " + removeBook);
                break;
            }
        }

        //전체 조회
        for(int i = 0; i < bookList.size(); i++) {
            System.out.println("도서명: " + bookList.get(i).getBookName());
            System.out.println("저자명: " + bookList.get(i).getAuthor());
        }
    }
}
