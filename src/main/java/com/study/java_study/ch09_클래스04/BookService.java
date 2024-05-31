package com.study.java_study.ch09_클래스04;

import java.util.Arrays;
import java.util.Scanner;

public class BookService {

    private Scanner scanner;
    private BookRepository bookRepository;

    public BookService() {
        scanner = new Scanner(System.in);
        bookRepository = new BookRepository();
    }

    private String selectMenu() {
        String[] menus = {"1", "2", "3", "4", "q"};
        String selectedMenu = null;

        while(true){
            System.out.print("메뉴 선택: ");
            selectedMenu = scanner.nextLine();//scanner 입력값을 selectedMenu에 대입
//            for(String menu : menus) {
//                if(menu.equals(selectedMenu)) { //위에서 입력받은 selectedMenu 값이 String menus{1, 2, 3, 4, q}안에 포함되어 있으면 true
//                    break;
//                }
//                System.out.println("잘못된 입력입니다. 다시 입력하세요.");//위에서 입력받은 selectedMenu 값이 menus(1234q) 중에 해당되지 않을 시

//            }
            if(Arrays.binarySearch(menus, selectedMenu) > -1) {
                break;
            }
            System.out.println("잘못된 입력입니다. 다시 입력하세요.");
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

        switch (selectedMenu) { //selectedMenu의 값에 따라 case를 실행한다.
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
                modify();
                break;
            case"4" :
                remove();
                break;
            default:
                System.out.println("[ 입력 오류 ]");
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

    private void remove() {
        System.out.println(" [ 도서 삭제 ]");
        search();
        System.out.print("삭제할 도서 번호 입력: ");
        int removeBookId = scanner.nextInt();
        scanner.nextLine();
        BookEntity book = bookRepository.findBookByBookId(removeBookId); //findBookByBookId 메서드를 통해 removeBookId와 일치하는 Id가 있는지 조회
        if(book == null) {
            System.out.println("해당 도서번호는 존재하지 않습니다.");
            return;
        }
        bookRepository.deleteBookByBookId(removeBookId);
    }

    private void modify() {
        System.out.println("[도서 수정]");
        search(); //search 메서드를 통해 수정할 책 검색
        System.out.print("수정할 도서번호 입력: ");
        int modifyBookId = scanner.nextInt(); //modifyBookId 변수에 수정할 도서번호를 저장
        scanner.nextLine();

        BookEntity book = bookRepository.findBookByBookId(modifyBookId); //modifyBookId와 일치하는 bookId가 있는지 bookRepository에서 탐색하여 book 변수에 대입
        if(book == null) { //modifyBookId와 일치하는 bookId가 없으면 null에 해당하여 "해당 도서번호는 존재하지 않습니다"가 출력된다.
            System.out.println("해당 도서번호는 존재하지 않습니다.");
            return;
        }
        System.out.println("<<도서 수정 정보 입력>>"); //modifyBookId와 일치하는 bookId가 있으면 도서 수정 정보 입력으로 넘어온다

        for(int i = 0; i < 3; i++) { //for문을 통해 아래 switch-case문을 차례대로 실행한다.
            String selected = null; //옵션을 담을 변수
            switch (i) { //for문을 통해 i가 0 -> 1 -> 2 순서로 커지면서 각 case가 실행된다
                case 0:
                    System.out.print("도서명을 수정하시겠습니까?(y/n)");
                    selected = scanner.nextLine(); //입력을 selected 변수에 담는다
                    if(selected.equalsIgnoreCase("y")) { //equalsIgnorecase : 대소문자 구분없이 같으면 됨
                        String bookName = duplicateBookName(); //bookName이 중복이 아니고 공백이 아닌지 검사한 후 그 값을 bookName에 대입
                        book.setBookName(bookName);
                        break;
                    }
                    break;
                case 1:
                    System.out.print("저자명을 수정하시겠습니까?(y/n)");
                    selected = scanner.nextLine();
                    if(selected.equalsIgnoreCase("y")) { //equalsIgnorecase : 대소문자 구분없이 같으면 됨
                        String author = validateValue("저자");
                        book.setAuthor(author);
                        break;
                    }
                    break;
                case 2:
                    System.out.print("출판사명을 수정하시겠습니까?(y/n)");
                    selected = scanner.nextLine();
                    if(selected.equalsIgnoreCase("y")) { //equalsIgnorecase : 대소문자 구분없이 같으면 됨
                        String publisher = validateValue("출판사");
                        book.setPublisher(publisher);
                        break;
                    }
            }
        }
    }

}