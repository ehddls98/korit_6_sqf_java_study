package com.study.java_study.ch20_람다;

@FunctionalInterface //람다 인터페이스에 사용하여 메소드를 1개 이상 작성하는 것을 막아준다.
public interface CustomKey {
    void onKeyPress();
}
