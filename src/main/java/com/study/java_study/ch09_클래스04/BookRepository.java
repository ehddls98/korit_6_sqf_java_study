package com.study.java_study.ch09_클래스04;

//repository : 저장소 -> CRUD
public class BookRepository {
    private int bookId;
    private BookEntity[] books;

    public BookRepository() {
        books = new BookEntity[0];
    }

    public int autoIncrementBookId() {
        return ++bookId;
    }

    private void extendBooks() {
        //기존 배열보다 크기가 하나 더 큰 배열을 생성한다.
        BookEntity[] newBooks = new BookEntity[books.length + 1];

        //기존 배열의 정보를 새로운 배열로 모두 옮긴다. 이 때 마지막 인덱스의 값은 빈값이다.
        for (int i = 0; i < books.length; i++) {
            newBooks[i] = books[i];
        }

        //기존 배열의 주소가 들어있는 books 변수에 새로운 배열의 주소를 대입한다.
        books = newBooks;
    }

    private int getLastIndex() {
        return books.length - 1;
    }

    public void saveBook(BookEntity book) {
        //배열 확장
        extendBooks();

        //새로운 배열의 비어있는 마지막 인덱스에 매개변수로 받아온 book 객체를 대입한다.
        books[getLastIndex()] = book;
    }

    //단건조회
    public BookEntity findBookByBookId(int bookID) {
        BookEntity findbook = null;

        //선형 탐색(순차 탐색)
        for (BookEntity book : books) {
            if (book.getBookId() == bookID) {
                findbook = book;
                break;
            }
        }
        return findbook;
    }

    //단건조회
    public BookEntity findBookByBookName(String bookName) {
        BookEntity findbook = null;

        for (BookEntity book : books) {
            if (book.getBookName().equals(bookName)) {
                findbook = book;
                break;
            }
        }
        return findbook;
    }

    private int getNewArraySize(int option, String searchText) {
        int newArraySize = 0; //옵션에 따라 실행된 케이스의 newArraySize 값에 따라 값이 증가

        switch (option) {
            case 1: //통합검색
                for (BookEntity book : books) {
                    if (book.getBookName().contains(searchText)
                            || book.getAuthor().contains(searchText)
                            || book.getPublisher().contains(searchText)) {
                        newArraySize++; //검색한 제목, 저자명, 출판사명이 리포지토리에서 조회될 경우 newArraySize의 값이 증그
                    }
                }
                break;
            case 2: //도서명
                for (BookEntity book : books) {
                    if (book.getBookName().contains(searchText)) {
                        newArraySize++; //검색한 책 제목이 리포지토리에 있을 경우 증가
                    }
                }
                break;
            case 3: //저자명
                for (BookEntity book : books) {
                    if (book.getAuthor().contains(searchText)) {
                        newArraySize++; //검색한 저자명이 리포지토리에 있을 경우 증가
                    }
                }
                break;
            case 4: //출판사명
                for (BookEntity book : books) {
                    if (book.getPublisher().contains(searchText)) {
                        newArraySize++; //검색한 출판사명이 리포지토리에 있을 경우 증가
                    }
                    break;
                }
        }
        return newArraySize; //option에 따라 실행된 케이스에서 증가된 값인 newArraySize를 리턴
    }

    //다건조회
    public BookEntity[] searchBooks(int option, String searchText) {
        int newArraySize = getNewArraySize(option, searchText); //search 메서드에서 입력받은 option과 searchtext를 매개변수로 하여 getNewArraySize 메서드를 실행하고
                                                                //그 리턴값을 newArraySize 변수에 대입한다.

        BookEntity[] searchBooks = new BookEntity[newArraySize]; //getNewArraySize 메서드를 통해 리턴된 값인 newArraySize의 값과 같은 크기의 배열 searchBooks를 생성

        int i = 0;
        switch (option) {
            case 1: //통합검색
                for (BookEntity book : books) {
                    if (book.getBookName().contains(searchText)
                            || book.getAuthor().contains(searchText)
                            || book.getPublisher().contains(searchText)) {
                        searchBooks[i] = book;
                        i++; // books 배열에 search 메서드에서 입력받은 값인 searchText 값이 포함된 문자열이 있으면 그 값을 searchBooks 배열에 0번 인덱스부터 차례대로 주입
                            // 검색 결과가 여러개일 경우 i 값이 계속 증가하며 searchBooks 배열에 계속해서 검색된 값을 주입
                    }
                }
                break;
            case 2: //도서명
                for (BookEntity book : books) {
                    if(book.getBookName().contains(searchText)) {
                        searchBooks[i] = book;
                        i++;
                    }
                }
                break;
            case 3: //저자명
                for (BookEntity book : books) {
                    if(book.getAuthor().contains(searchText)) {
                        searchBooks[i] = book;
                        i++;
                    }
                }
                break;
            case 4: //출판사명
                for (BookEntity book : books) {
                    if (book.getPublisher().contains(searchText)) {
                        searchBooks[i] = book;
                        i++;
                    }
                }
        }
        return searchBooks; //각 케이스가 option에 따라 실행 된 결과 생성된 searchBooks 배열을 리턴
    }
}



