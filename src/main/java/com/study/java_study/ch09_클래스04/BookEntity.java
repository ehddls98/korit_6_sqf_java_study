package com.study.java_study.ch09_클래스04;

public class BookEntity {
    //entity : 특정 객체(학생, 학원, 병원, 책 등)의 정보에 대한 집합
    //entity에는 constructor랑 getter, setter 필수
    private int bookId;
    private  String bookName;
    private  String author;
    private  String publisher;

    public BookEntity(int bookId, String bookName, String author, String publisher) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.publisher = publisher;
    }

    public BookEntity() {
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}
