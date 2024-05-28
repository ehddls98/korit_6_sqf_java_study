package com.study.java_study.ch09_클래스04;

import java.util.Scanner;

public class BookService {

    private Scanner scanner;
    private BookRepository bookRepository;

    public BookService() {
        scanner = new Scanner(System.in);
        bookRepository = new BookRepository();
    }

    private String selectMenu() {
        String menus = "1234q";
        String selectedMenu = null;

        while(true){
            System.out.print("메뉴 선택: ");
            selectedMenu = scanner.nextLine(); //scanner 입력값을 selectedMenu에 대입
            if(menus.contains(selectedMenu)) { //위에서 입력받은 selectedMenu 값이 menus(1234q)안에 포함되어 있으면 true
                break;
            }
            System.out.println("잘못된 입력입니다. 다시 입력하세요."); //위에서 입력받은 selectedMenu 값이 menus(1234q) 중에 해당되지 않을 시
        }

        return selectedMenu; //scanner로 입력받은 값을 리턴한다.
    }

    public boolean run() {
        boolean isRun = true;

        System.out.println(" [ 도서 관리 프로그램 ] ");
        System.out.println("1. 도서 등록");
        System.out.println("2. 도서 검색");
        System.out.println("3. 도서 수정");
        System.out.println("4. 도서 삭제");
        System.out.println("q. 프로그램 종료");

        String selectedMenu = selectMenu(); //selectMenu() 메서드의 리턴값을 selectedMenu에 대입한다.

        switch (selectedMenu) { //selectedMenu의 값에 따라 case를 실행한다
            case"q" :
                isRun = false;
                break;
            case"1" :
                registerBook();
                break;
            case"2" :
                search();
                break;
            case"3" :
                break;
            case"4" :
                break;
            default:
                System.out.println("입력 오류");
        }
        System.out.println();
        return isRun;
    }

    private String validateValue(String title) {
        String value = null;
        while(true) {
            System.out.print(title + "명 입력: "); //title(도서명, 저자명, 출판사명)
            value = scanner.nextLine(); //scanner로 입력받은 값을 value에 대입한다.
            if(!value.isBlank()) { // isBlank(): "", " " / isEmpty: "" scanner 입력값이 공백인지 확인하고 공백이 아니면 true
                break;
            }
            System.out.println(title + "명은 공백일 수 없습니다. 다시 입력하세요.");
        }
        return value; //scanner 입력값이 공백이 아닐때의 입력값을 리턴
    }

    private String duplicateBookName() {
        String bookName = null;
        while(true) {
            bookName = validateValue("도서"); //validateValue 메서드에서 입력값이 공백이 아님을 확인한 값을 bookName에 대입한다.
            if(bookRepository.findBookByBookName(bookName) == null) { //findBookByBookName 메서드를 통해 리포지토리에 같은 제목의 도서가 있는지 확인
                break;
            }
            System.out.println("해당 도서명이 이미 존재합니다. 다시 입력하세요.");
        }
        return bookName; //findBookByBookName 메서드를 통해 같은 제목의 도서가 없는 것이 확인 되었을때 입력된 책 제목을 리턴
    }

    private void registerBook() {
        System.out.println("[ 도서 등록 ]");
        int bookId = bookRepository.autoIncrementBookId(); //bookRepository 클래스에 있는 autoIncrementBookID 메서드를 실행하여 그 값을 bookId에 대입한다.
        String bookName = duplicateBookName(); //공백이 아니고 리포지토리에 같은 제목의 도서가 없는 것이 확인된 책 제목을 bookName에 대입
        String author = validateValue("저자"); //공백이 아닌것이 확인된 입력값을 author에 대입
        String publisher = validateValue("출판사"); //공백이 아닌것이 확인된 입력값을 publisher에 대입

        BookEntity book = new BookEntity(bookId, bookName, author, publisher); //book이라는 새로운 BookEntity 객체를 생성
        bookRepository.saveBook(book); //saveBook 메서드를 통해 새로 생성된 BookEntity를 저장
        System.out.println("새로운 도서를 등록하였습니다.");
    }

    private void search() {
        System.out.println(" [ 도서 검색 ]");
        System.out.println("1. 통합 검색");
        System.out.println("2. 도서명 검색");
        System.out.println("3. 저자명 검색");
        System.out.println("4. 출판사명 검색");
        System.out.print("옵션 선택: ");
        int option = scanner.nextInt(); //scanner 입력값을 option에 대입한다.
        scanner.nextLine(); //nextInt의 버퍼에 Enter입력이 저장되지 않기 때문에 그 입력을 대신 받기 위한 코드
        System.out.print("검색어 입력: ");
        String searchText = scanner.nextLine(); //scanner 입력값을 searchText에 대입한다.
        BookEntity[] searchBooks = bookRepository.searchBooks(option, searchText); //searchBooks 메서드를 통해 리턴된 배열을 searchBooks 배열에 대입한다.

        System.out.println(" [ 검색 결과 ]");
        if(searchBooks.length == 0) { //searchBooks 메스드를 통해 리턴된 배열이 비어있으면 true
            System.out.println("검색 결과가 없습니다.");
            return;
        }
        for(BookEntity book : searchBooks) {
            System.out.println(book.toString()); //searchBooks 메서드를 통해 리턴된 배열을 출력
        }
    }
}