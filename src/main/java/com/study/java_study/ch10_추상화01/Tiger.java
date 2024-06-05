package com.study.java_study.ch10_추상화01;

public class Tiger extends Animal{

    private int power;

    public Tiger() {
        super(); //Animal 객체(부모 객체) 생성자 호출, super()는 자식보다 먼저 생성되어야 한다, 생략되어 있다
        System.out.println("호랑이 객체 생성");
    }

    public Tiger(String name, int age, int power) { //부모 클래스인 Animal에 name, age를 포함한 allArgsConstructor가 있기 때문에 생성 가능
        super(name, age); //부모 생성자가 먼저 생성되어야 한다. 순서가 바뀌면 오류
        this.power = power;
    }

    //재정의 -> 상속관계에서만 가능
    @Override //@Override 어노테이션은 기능은 없지만 재정의 했다는 것을 표시하기 위해 쓴다. 없어도 잘 동작함
                //재정의한 메서드는 업캐스팅해도 자식의 메서드가 실행된다.
    public void move() {
        System.out.println("호랑이가 네발로 뛰어갑니다.");
        super.move();
    }

    public void hunt() {
        System.out.println("호랑이가 " + power + "의 힘으로 사냥을 합니다.");
    }

    @Override
    public String toString() {
        return "Tiger{" +
                "power=" + power +
                "} " + super.toString();
    }
}