package com.study.java_study.ch17_컬렉션;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookService {

    //싱글톤
    private static BookService instance;

    private BookService() {} //외부에서 새로운 객체를 생성할 수 없도록 생성자에 private 접근지정자를 설정한다.

    public static BookService getInstance() { //최초 한번만 객체를 생성하고 그 다음부터는 getInstance를 할때마다 최초에 생성한 객체를 리턴한다.
        if(instance == null) {
            instance = new BookService();
        }
        return instance;
    }

    private List<Map<String, Object>> bookDB = List.of( //List안에 Map들을 생성해서 넣는다.
            Map.of(
                    "bookId", 1,
                    "bookName", "자바의 정석"
            ),
            Map.of(
                    "bookId", 2,
                    "bookName", "파이썬의 정석"
            ),
            Map.of(
                    "bookId", 3,
                    "bookName", "데이터베이스의 정석"
            )
    );

    public void run1() {
        System.out.println("도서 전체 정보를 요청합니다.");
        run2();
    }

    public void run2() {
        System.out.println("도서 전체 정보 요청을 받습니다.");
        List<BookEntity> bookEntities = run3(); //run3()에서 bookEntity들을 넣은 bookEntities(list)를 bookEntities(list)에 대입
        BookRequestDto bookRequestDto = new BookRequestDto(200, "조회 완료", bookEntities);
        //bookRequestDto 객체를 생성하고 status(200), message("조회 완료"), bookEntities(list)를 각 파라미터에 주입
        run4(bookRequestDto); //run4() 메서드에 새로 생성한 bookRequestDto를 전달하고 실행시킨다
    }

    public List<BookEntity> run3() {
        System.out.println("데이터 베이스에서 도서 전체 정보를 조회합니다.");

        List<BookEntity> bookEntities = new ArrayList<>(); //새로운 List 생성

        for(Map<String, Object> bookMap : bookDB) { //bookDB에서 map을 하나씩 꺼내 bookMap에 하나씩 할당
            BookEntity bookEntity = new BookEntity( //bookEntity 객체 생성
                    (int) bookMap.get("bookId"), //bookEntity의 bookId는 int 자료형이고 bookMap의 bookId는 String 자료형이기 때문에 다운캐스팅 해야한다
                    (String) bookMap.get("bookName") //bookEntity의 bookName는 String 자료형이고 bookId의 bookName은 Object 자료형이기 때문에 다운캐스팅 해야한다
        );

        bookEntities.add(bookEntity); //bookEntities(list)에 bookEntity 하나씩 할당
        }
        return bookEntities; //bookEntities(list)를 리턴한다.
    }

    public void run4(BookRequestDto bookRequestDto) {
        System.out.println("데이터 베이스의 정보를 요청한 클라이언트에게 응답합니다.");
        System.out.println("[ 응답 데이터 ]");
        System.out.println(bookRequestDto); //run2에서 전달받은 bookRequestDto를 출력한다.(status, message, bookEntities 리스트)
    }
}