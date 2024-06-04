package com.study.java_study.ch20_람다;

public class AdditionMain {

    public static void main(String[] args) {

        Addition addition = new Addition() {
            @Override
            public int add(int x, int y) {
                return x + y;
            }
        };

        int result = addition.add(10, 20);
        System.out.println("결과: " + result);

        //위의 코드를 람다로 작성한 코드
        Addition addition2 = (x, y) -> x + y; //익명클래스의 생성과 메서드 정의를 람다 한줄로 표현할 수 있다.
        result = addition2.add(10, 20);
        System.out.println("결과: " + result);
    }
}
