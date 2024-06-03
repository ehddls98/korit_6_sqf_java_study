package com.study.java_study.ch11_추상화02;

public class AnimalMain {

    public static void main(String[] args) {
 //       Animal a = new Animal();

        Animal[] animals = new Animal[10];

        for(int i = 0; i < animals.length; i++) {
            animals[i] = i % 2 == 0 ? new Dog() : new Tiger(); //animals 배열에 i가 짝수면 new Dog()를 넣고, i가 홀수면 new Tiger()를 넣는다.
        }

        for(Animal animal : animals) {
            animal.move(); //Dog와 Tiger 클래스에서 move() 메서드를 오버라이딩 했기 때문에 각자 다른 메시지를 출력한다.
        }
    }
}
