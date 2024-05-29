package com.study.java_study.ch11_추상화02;

public class AnimalMain {

    public static void main(String[] args) {

        Animal[] animals = new Animal[10];

        for(int i = 0; i < animals.length; i++) {
            animals[i] = i % 2 == 0 ? new Dog() : new Tiger();
        }

        for(Animal animal : animals) {
            animal.move(); //Dog와 Tiger 클래스에서 move() 메서드를 오버라이딩 했기 때문에 각자 다른 메시지를 출력한다.
        }
    }
}
