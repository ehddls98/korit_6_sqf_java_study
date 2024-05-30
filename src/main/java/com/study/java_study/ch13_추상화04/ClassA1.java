package com.study.java_study.ch13_추상화04;

public class ClassA1 extends ClassA{

    @Override
    public void print(InterfaceA interfaceA) {
        System.out.println("A1 클래스에서 print 호출");
        interfaceA.test(); // print 메서드는 InterfaceA에서 객체를 받아야만 실행되기 때문에 print 메서드는 InterfaceA에 의존성을 가지고 있다.
                            //이걸 의존성 주입(DI)라고 한다.
    }
}
