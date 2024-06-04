package com.study.java_study.ch18_빌더;

public class Main {

    public static void main(String[] args) {
        //내부 클래스
        A a = new A();
        A.B b = a.new B(); // A 클래스를 먼저 생성해야 내부 클래스인 B 클래를 생성할 수 있다.

        a.test();
        b.print();

        A.C c = new A.C(); //C는 스태틱 클래스
        c.show();

        A.C.show2(); //show2()는 A의 내부 클래스인 C의 스태틱 메서드
    }
}
