package com.study.java_study.ch19_익명클래스;

public class ButtonMain {

    public static void main(String[] args) {

        click(new HomeButton()); //click 메서드의 파라미터로 HomeButton 객체를 생성하여 넣어준다

        //익명클래스
        click(new Button() {
            @Override
            public void onClick() {

                System.out.println("로그인 하기");
            }
        });
    }

    public static void click(Button button) {
        System.out.println(button.getClass()); //HomeButton은 클래스명이 출력되지만, loginButton은 클래스명이 ButtonMain의 $1 클래스라고 출력된다, 즉 이름이 없다.
        button.onClick();
    }
}
