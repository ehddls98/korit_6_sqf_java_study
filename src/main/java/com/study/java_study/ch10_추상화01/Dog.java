package com.study.java_study.ch10_추상화01;

public class Dog extends Animal{
    private String breed;

    public Dog() {
        super();
        //Animal 객체(부모 객체) 생성자 호출, super()는 자식보다 먼저 생성되어야 한다,
        // 부모 클래스에 기본 생성자만 있을 경우에는 super()는 자바 컴파일러가 자동으로 생성해주기 때문에 생략가능하다.
        System.out.println("강아지 객체 생성");
    }

    public Dog(String name, int age, String breed) { //부모 클래스인 Animal에 name, age를 포함한 allArgsConstructor가 있기 때문에 생성 가능
        super(name, age);
        //자식 클래스에서 기본 생성자 외의 생성자를 정의 할때는 부모 생성자가 먼저 생성되어야 한다. 순서가 바뀌면 오류
        this.breed = breed;
    }

    @Override //ctrl + o
    public void move() {
        System.out.println("강아지가 네발로 움직입니다.");
    }

    public void bark() {
        System.out.println(breed + "종의 강아지가 짖습니다.");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "breed='" + breed + '\'' +
                '}';
    }
}
