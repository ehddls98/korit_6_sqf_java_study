package com.study.java_study.ch10_추상화01;

public class AnimalMain {

    public static void main(String[] args) {
        Dog dog = new Dog("콩이", 11, "말티즈");
        Animal tiger = new Tiger("웅이", 5, 100); //부모 클래스로 업캐스팅

        System.out.println(dog.toString());
        System.out.println(tiger.toString());

        dog.move();
        tiger.move(); //업캐스팅 했지만 오버라이딩한 메서드가 실행된다. Tiger 클래스의 move() 메서드에 부모의 move()메서드를 실행하기 위해서 super.move()를 추가했음
        ((Tiger)tiger).hunt(); //Animal 클래스에 없는 메서드는 다운캐스팅 후 사용가능
        dog.bark();

        Animal[] animals = new Animal[3];
        animals[0] = new Animal("이름없는 동물", 10);
        animals[1] = new Dog("콩이", 11, "말티즈");
        animals[2] = new Tiger("웅이", 5, 100);

        for(Animal animal : animals) {
            animal.move();
        }

        System.out.println();

        for(Animal animal : animals) {
            if(animal instanceof Tiger) { //instanceof Tiger : 원래 자료형을 확인하고 Tiger면
                Tiger t = (Tiger) animal; //animal을 Tiger로 다운캐스팅 하고 hunt() 메서드 실행
                t.hunt();
            } else if (animal instanceof Dog) {
                Dog d = (Dog) animal;
                d.bark();
            }
        }

        for(Animal animal : animals) {
            if(animal.getClass() == Tiger.class) { //Java 최신버전에서는 instanceOf가 삭제됨
                Tiger t = (Tiger) animal; //animal을 Tiger로 다운캐스팅 하고 hunt() 메서드 실행
                t.hunt();
            } else if (animal.getClass() == Dog.class) {
                Dog d = (Dog) animal;
                d.bark();
            }
        }

        /*
        Tiger t = new Tiger()
        Animal a2 = new Tiger() -> 업캐스팅(자식->부모)
        Tiger t2 = (Tiger)a2 -> 다운캐스팅(부모-> 자식)

        Animal a = new Dog()
        Tiger t = (Tiger) a -> 불가능하다

        Animal[] animals = new Animal[3]
        animal[0] = new Animal();
        animal[1] = new Tiger();
        animal[2] = new Dog();
        -> Animal 자료형으로 묶을수 있다. 추상화의 용도
         */

    }
}
