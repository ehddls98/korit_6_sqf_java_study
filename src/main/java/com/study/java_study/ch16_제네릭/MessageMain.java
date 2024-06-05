package com.study.java_study.ch16_제네릭;

public class MessageMain {

    public static void main(String[] args) {

        //제네릭 와일드 카드 : 기호 -> ?(=Object)

        Message<?> m1;
        Message<String> m2 = null;

        m1 = new Message<>("10");
        //m1은 제네릭으로 <?> 와일드카드 자료형이 설정되어 있다.
        // 와일드카드(?)를 String 자료형에 넣으려면 다운캐스팅을 해야한다.
        String s = (String) m1.getMessage();

        //와일드 카드 제약
        Message<? extends String> m3 = new Message<>("10"); //하행 -> String을 포함한 상속받은 자료형만 와일드 카드로 허용
        Message<? super String> m4 = new Message<>(new Object()); //상행
        //와일드 카드의 범위

        String s2 = m3.getMessage(); //m3는 String을 포함하고 있기 때문에 다운캐스팅 하지 않아도 됨.

    }
}
