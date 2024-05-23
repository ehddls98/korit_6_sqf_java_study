package com.study.java_study.ch03_함수;

public class Function04 {

   //오버로딩 : 매개변수의 갯수, 자료형이 다르면 동일한 이름의 메소드를 여러개 만들수 있다.

    void add(int a, int b){
        System.out.println(a + b);
    }

    void add(int a, int b, int c){
        System.out.println(a + b + c);
    }

    void add(int a, String b){
        int c = Integer.parseInt(b);
        System.out.println(a + c);
    }
}
