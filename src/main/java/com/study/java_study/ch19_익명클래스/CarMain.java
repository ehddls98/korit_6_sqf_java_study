package com.study.java_study.ch19_익명클래스;

public class CarMain {

    public static void main(String[] args) {
        KiaCar kiaCar = new KiaCar("k8", "화이트");
        System.out.println(kiaCar);

        //익명 클래스
        // 이름이 없고 클래스 파일이 없는 일회용 클래스(ex: 로그인 버튼)
        // 익명 클래스는 추상클래스, 추상클래스를 상속받은 클래스, 인터페이스로만 만들 수 있다.
        // 익명 클래스에는 상속받는 클래스의 메소드들만 사용할 수 있고 새로운 메소드를 만들 수는 없다.

        AbstractCar abstractCar = new AbstractCar("내가만든자동차", "블랙") {
            // -> 추상 클래스를 생성한것 같지만 아니다, 사실은 익명클래스가 상속받을 클래스(추상클래스, 인터페이스)를 선언한 것이다.
            // "{" 뒤부터 클래스 정의, 즉 추상 클래스의 메서드들을 오버라이딩하고 익명 클래스의 메서드들을 재정의 하는 것이다.
            @Override
            public void createCar() {
                System.out.println("한번 만들어봄");
            }

            @Override
            public void showCar() {
                System.out.println("자동차 정보...");
            }
        };
    }
}
