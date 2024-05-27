package com.study.java_study.ch06_배열;

public class BookArrayUtils {

    int findIndexByBook(String[] books, String title) {
        for(int i = 0; i < books.length; i++) {
            if(books[i].equals(title)) {
                return i;
            }
        }
        return -1;
    }
}
